package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
//https://www.youtube.com/watch?v=BP7GCALO2v8
public class QuickSelectSortingAlgo {

    //ideally people will not allow you to use dort method.
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        if(k==1) return nums[nums.length-1];

        return nums[nums.length-k];

    }

    public int findKthLargestWithoutInbuiltSort(int[] nums, int k) {

    return quickSelectAlgo(nums,0,nums.length-1,k);

    }

    public int quickSelectAlgo(int[] num , int start, int end,int k)
    {
        int pivot = end;
        int right = end-1;// as i want all elment to be placed pivot element and finally will replace pivot with largest
        int left = start;

        while (left<=right)
        {
            if(num[left]>num[pivot])
            {
                swap(num,left,right);// as right is end-1 so it will never replace the pivot element in this loop.
                right--;
            }else
                left++;
        }

        //we need to replace the pivot with the left because right has went through left side and placed all big element to right
        swap(num,left,pivot);

        int rank = num.length-left;
        if(rank==k) return num[left];
        if(rank<k) return quickSelectAlgo(num,start,left-1,k);
        else return quickSelectAlgo(num,left+1,end,k);
    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public static void main(String[] args) {
    QuickSelectSortingAlgo quickSelectSortingAlgo = new QuickSelectSortingAlgo();
    int a[] ={3,2,3,1,2,4,5,5,6};
        System.out.println(quickSelectSortingAlgo.findKthLargestWithoutInbuiltSort(a,4));
    }
}
