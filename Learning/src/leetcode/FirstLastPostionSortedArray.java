package leetcode;

import leetcode.utils.Util;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstLastPostionSortedArray {
    public static int[] searchRange(int[] nums, int target) {

        int[] response = {-1,-1};
        int len = nums.length;
        if(len==0) return response;
        return binarySearch(nums,0, len-1,len, target, response);
    }

    static int[]  binarySearch(int[] nums, int low, int high,int len, int target, int[] response){
        if(low>high) return response;

        int mid = (low+high)/2;

        if(nums[mid]==target)
        {
            int lef = mid;
            int right =mid;

            // as array is sorted we need to look to left most element till it is matching.
            while(lef>=0 && lef<len && target==nums[lef])
            {
                response[0] =lef;
                lef--;
            }
            // as array is sorted we need to look to right most element till it is matching.
            while(right <len && right >=0 && target==nums[right] )
            {
                response[1] =right;
                right++;
            }
            // the moment we get the ans we will return it
            return response;
        }
        //normal binary search call
        if(target > nums[mid])
            return binarySearch(nums,mid+1, high,len, target, response);
        else
            return binarySearch(nums,low, mid-1,len, target, response);

    }

    public static void main(String[] args) {

        int nums[] = {3,3,3};

        Util.printArray(searchRange(nums,3));
    }
}
