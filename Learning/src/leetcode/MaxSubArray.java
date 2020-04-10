package leetcode;

public class MaxSubArray {
    // Find the maximum possible sum in arr[]
    // such that arr[m] is part of it
    static int maxCrossingSum(int arr[], int l,
                              int m, int h)
    {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--)
        {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++)
        {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        return left_sum + right_sum;
    }

    // Returns sum of maxium sum subarray
    // in aa[l..h]
    static int maxSubArraySum(int arr[], int l,
                              int h)
    {
        // Base Case: Only one element
        if (l == h)
            return arr[l];

        // Find middle point
        int m = (l + h)/2;

        int lef_max = maxSubArraySum(arr, l, m);
        int right_max =  maxSubArraySum(arr, m+1, h);
        int max = Math.max(lef_max,right_max);
        int max2 =maxCrossingSum(arr, l, m, h);
        return Math.max(max,max2);
    }

    /* Driver program to test maxSubArraySum */
    public static void main(String[] args)
    {
        int arr[] = {2, 3, 4, 5, 7};
        int n = arr.length;
        int max_sum = maxSubArraySum(arr, 0, n-1);

        System.out.println("Maximum contiguous sum is "+
                max_sum);
    }
}
