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

    public static void print2DArray(int nums[][])
    {
        if(nums==null)
            System.out.println("Array is null");

        if(nums.length==0)
            System.out.println("Array is empty");

        for (int a[]:nums) {

            for (int b :
                    a) {
                System.out.print(b +" ");
            }
            System.out.println();

        }
    }
}
