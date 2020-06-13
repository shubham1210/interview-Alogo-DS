package leetcode;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRoatatedSortedArray {

    public static int search(int[] nums, int target) {

        int len = nums.length;
        if (len == 0) return -1;
        return twickedBinarySearch(nums, 0, len - 1, target);
    }

    private static int twickedBinarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;

        if(nums[mid] ==target)return mid;
        //left part is sorted we can then apply normal search in to it.
        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target <= nums[mid])
                return twickedBinarySearch(nums, low, mid - 1, target);// as it is not found at mid above that and it is in range of low and mid so we are just reduicing mid by1
            else
                return twickedBinarySearch(nums, mid + 1, high, target);
        }
        else if (target >= nums[mid] && target <= nums[high]) // if target fall under
                return twickedBinarySearch(nums, mid+1, high, target);
        else
                return twickedBinarySearch(nums, low, mid-1, target);

    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(a, 0));

    }
}
