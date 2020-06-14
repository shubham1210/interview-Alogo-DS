package leetcode.utils;

/**
 * Created by shubhamsharma on 2020-06-14.
 */
public class Util {

    public static void printArray(int nums[])
    {
        if(nums==null)
            System.out.println("Array is null");

        if(nums.length==0)
            System.out.println("Array is empty");

        for (int a:nums


             ) {

            System.out.print(a+", ");

        }
    }
}
