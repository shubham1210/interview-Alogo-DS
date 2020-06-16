package leetcode;

/*

 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length==0) return 0;
        int left = 0, right = height.length-1;
        int leftMax=0, rightMax=0;
        int ans = 0;

        //
        while (left < right) {

            if (height[left] > leftMax) leftMax = height[left];
            if (height[right] > rightMax) rightMax = height[right];

            // the area can only be covered if leftmax is greater then current left
            // till the time leftmax is smaller than right max we need to keep moving from left side
            // we also need to think we are comparing left max and right max here but we only working on left elements to compute water storage
            // so idea is to make sure left wall boundary should not go more than right one.
            // in other words the moment left is decending from left max we calculate water area.
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-height[left]);
                left++;
            } else { // if left boundary us greater than right boundry that mean we need to move right till then we dont find the right big boundry
                ans += Math.max(0, rightMax-height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = { 0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(a));
    }
}
