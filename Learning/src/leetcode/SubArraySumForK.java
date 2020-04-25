package leetcode;

import java.util.HashMap;

public class SubArraySumForK {


    public static int subarraySum(int[] arr, int k) {
        //map is used to store cumulative  sum that means any sum that has gone while iterating past elements
        HashMap<Integer,Integer> prevSum = new HashMap<>();
        int currSum =0;
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            currSum+=arr[i];

            if(currSum==k)count++;

            //example i ==2 till then currSum went to 7 and then i==3 it is 7+7=14 but i==3 itself a array
            // so currSum-k => 14-7
            // one more expamle is 0,0,0,0 so every time currsum =0 and it will ve saved as +1 in prevSum that mean {0 =1} , {0,0= 1} , {0=1},{0=1} then it will 3
            if(prevSum.containsKey(currSum-k))
                count+=prevSum.get(currSum-k);

            if(prevSum.get(currSum)==null)
                prevSum.put(currSum,1);
            else
                prevSum.put(currSum,prevSum.get(currSum)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        //int arr[] = {3,4,7,2,-3,1,4,2};
        int arr[] = {0,0,0,0,0,0,0,0,0,0};

        //int arr[] = {1,2,3};
        System.out.println(subarraySum(arr,0));
    }
}