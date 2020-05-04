package leetcode;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobberDP {
    public int rob(int[] nums) {
        int n =  nums.length;
        if(n==0)return 0;
        if(n==1) return nums[0];

        int max[] = new int[n];

        max[0] = nums[0];
        max[1] = Math.max(nums[0],nums[1]);
        int i=2;
        for(i=2;i<n;i++)
        {
            // so we are checking at i we can onlt look back i-2 due to question constrained and see if current postion + last i-2 processed
            // positon is greater than last processed postion. i-1
            max[i] = Math.max(nums[i]+max[i-2] , max[i-1]);
        }

        return max[n-1];

    }

    public static void main(String[] args) {
        int a[] = {2,1,1,2};
        HouseRobberDP dp = new HouseRobberDP();
        System.out.println(dp.rob(a));
    }
}
