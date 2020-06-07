package leetcode;

/**
 * Created by shubhamsharma on 2020-06-07.
 * https://leetcode.com/problems/3sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class ThreeSum {


    // this will give all sum even duplicates also.
    public List<List<Integer>> threeSumSlow(int[] nums) {

        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> midList = null;
        HashSet<Integer> set = null;
        Arrays.sort(nums);

        for(int i=0;i<len;i++)
        {
            set = new HashSet<Integer>();
            for(int j=i+1;j<len;j++)
            {
                int x =  -(nums[i]+nums[j]);

                if(set.contains(x))
                {
                    midList = new ArrayList<Integer>(3);
                    midList.add(x);midList.add(nums[i]);midList.add(nums[j]);
                    if(ans.contains(midList)==false)
                        ans.add(midList);
                }else
                    set.add(nums[j]);
            }
        }

        return ans;
    }

    //19ms time execution.
    public List<List<Integer>> threeSumFast(int[] num) {
        if(num == null){
            return null;
        }

        int len = num.length;
        List<List<Integer>> res = new ArrayList<>();

        // this will help to maintain 2 pointer low and high that why soreted
        Arrays.sort(num);

        // as i is going to start from i+1 so we need to maitain 1 postion diffrence and it should not go out of bound.
        for (int i = 0; i < len-2; i++) {

            //-4,-1,-1,0,1,2
            // so 2 elements are same next to eachother than we should skip the next elemetn so lest suppose -1 is processed at 1 index then we come to 2 index same element is  there so that combination coming fromt element will be same so we skil that element as we are coming from high to low side.
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {

                int lo = i+1, hi = len-1;

                while (lo < hi) {
                    if (num[lo] + num[hi] +num[i] == 0) {

                        res.add(Arrays.asList(num[i], num[lo], num[hi]));

                        //so this condition to check after sort if 2 element are same next to eachother and you can see we have proceesed them using lo and high and we can skip low and high elelmetns.
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;

                        lo++; hi--;

                    } else if (num[lo] + num[hi] +num[i]  < 0) { // is sum is less then we should increse low because low has lowset elemetn after sorting
                        lo++;
                    } else {
                        hi--; // if sum is gng above 0 that means we need to do subract higer number
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        ThreeSum sum = new ThreeSum();
        System.out.println(sum.threeSumFast(arr));
    }
}
