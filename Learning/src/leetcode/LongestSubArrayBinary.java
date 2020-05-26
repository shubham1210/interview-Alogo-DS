package leetcode;

import java.util.HashMap;

public class LongestSubArrayBinary {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max_len =0;
        int sum=0;int i=0;
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        while(i<n)
        {
            if(nums[i]==0 )
            {
                nums[i]=-1;
            }
            i++;
        }

        i=0;

        while(i<n)
        {
            sum+=nums[i];

            if(sum==0){
                max_len =i+1;
            }
            //if than processed sum is there that mean need to pick greater
            if(hM.containsKey(sum+n))
            {
                // this line means sum is repeating that means we need to see that last saved sum is  greater than current max_len then update maxlen not hm it will be same.
                //repeating sum also means the zero and 1 are same at this point like in past
                if(max_len <  i-hM.get(sum+n))
                {
                    max_len = i- hM.get(sum+n); // we are subtracting from i because we need to see the length should be consider after i that is current index
                }

            }else{
                hM.put(sum+n,i); // this is maitaing sum with the current position or you can say the lenght at that time. and n is used as a constant
            }

            i++;
        }
        return max_len;
    }

    /* Driver program to test the above functions */

    public static void main(String[] args) {
        LongestSubArrayBinary sub = new LongestSubArrayBinary();
        //int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int arr[] = {0,0,1,0,0,0,1,1};

        //int arr[] = {0,1,0};
        sub.findMaxLength(arr);
    }
}


