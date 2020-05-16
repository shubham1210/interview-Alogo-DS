package leetcode;

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] A) {
        int size = A.length;
        int maxSumWitoutInversion = kadanesAlog(A);


        int sumOfWholeArray=0;
        //we need to keep the MaxElement in case all element are -ve in list so we need to choose the biggest one.
        int maxElement =Integer.MIN_VALUE;
        for (int i = 0; i < size; i++)
        {
            if(maxElement<A[i])
                maxElement = A[i];
            sumOfWholeArray+=A[i]; //summing the array and reverting in next line

            A[i] = -A[i];// reversing the each index.
        }

        sumOfWholeArray = sumOfWholeArray + kadanesAlog(A);
        //we need to keep the MaxElement in case all element are -ve in list so we need to choose the biggest one.
        if(sumOfWholeArray == 0 && maxSumWitoutInversion==0)return maxElement;

        return maxSumWitoutInversion>sumOfWholeArray ? maxSumWitoutInversion:sumOfWholeArray;

    }


    public int kadanesAlog(int[] A)
    {
        int size = A.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + A[i];

            if (max_ending_here < 0)
                max_ending_here = 0;

            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;


        }
        return max_so_far;

    }

    public static void main(String[] args) {
        int arr[] = {-3,-5,-2,-5,-6};
        MaxSubarraySumCircular maxSubarraySumCircular = new MaxSubarraySumCircular();
        System.out.println(maxSubarraySumCircular.maxSubarraySumCircular(arr));

    }
}
