package leetcode;

import java.util.HashMap;

public class LongestSubArrayBinary {

    // Returns largest subarray with equal number of 0s and 1s

    public int maxLen(int[] nums) {
        int n = nums.length;
        int max_len = 0;
        int sum = 0;
        int i = 0;
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        while (i < n) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            i++;
        }
        i = 0;

        while (i < n) {
            sum += nums[i];

            //SUM=0 means you have array of where 1 and  0 are equals
            if (sum == 0) {
                max_len = i + 1;
            }

            if (hM.containsKey(sum + n)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n); // we are subracting from i because we need to see the length should be consider after i that is current index
                    //sum can be 0 many time in an array with diffrent lengths so for exp -1 can come many times.
                }
            } else {
                hM.put(sum + n, i);// question is why sum + n becuase sum can maximum go to -n to n that means -1 is all over the array or 1 is allover the array
                // this is maitaing sum with the current position or you can say the lenght at that time. and n is used as a constant

            }

            i++;
        }
        return max_len;
    }

    /* Driver program to test the above functions */

    public static void main(String[] args) {
        LongestSubArrayBinary sub = new LongestSubArrayBinary();
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        //int arr[] = {0,1,0};
        sub.maxLen(arr);
    }
}


