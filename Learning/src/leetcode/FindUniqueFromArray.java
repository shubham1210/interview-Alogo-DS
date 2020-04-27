package leetcode;

/**
 * Created by shubhamsharma on 2020-03-17.
 */
public class FindUniqueFromArray {

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args) {

        int a[]=new int[]{4,1,2,1,2};
         System.out.print(singleNumber(a));;
    }
}
