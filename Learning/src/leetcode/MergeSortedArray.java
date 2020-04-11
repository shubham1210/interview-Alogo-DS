package leetcode;

public class MergeSortedArray {
    //merging need to be taken from left as smaller can be conflicting from starting but the larget eill alwasy from the end.
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int tail1 = m - 1, tail2 = n - 1, bigArrLastIndex = m + n - 1;

        while (tail1 >= 0 && tail2 >= 0) {
            //which ever is greater need to placed at end of the array
            if (nums1[tail1] > nums2[tail2])
            {
                nums1[bigArrLastIndex] = nums1[tail1--];
            } else
                nums1[bigArrLastIndex] = nums2[tail2--];

            bigArrLastIndex--;
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[bigArrLastIndex--] = nums2[tail2--];
        }


    }


    public static void main(String[] args) {
        int num1[] = {1, 2, 3, 0, 0, 0};
        int num2[] = {2, 5, 6};
        merge(num1, 3, num2, num2.length);
    }
}
