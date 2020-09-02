package leetcode;

/**
 * Created by shubhamsharma on 2020-06-30.
 */
public class JumpGame {

        public static boolean canJump(int[] nums) {
            int len = nums.length;
            int dp[] = new int[len];
            if(len==1 ) return true;
            return canJumpRec(nums,dp,0,len);
        }

        public static boolean canJumpRec(int[] nums,int[] dp ,int index, int len)
        {
            for(int i =0 ;i <len;i++)
            {
                int indexValue = nums[i];
                while(indexValue>0)
                {
                    if(indexValue+i ==i){
                        break;
                    }else if(indexValue+i < len){
                        dp[indexValue+i] = dp[indexValue+i]+1;
                    }
                    indexValue--;
                }
            }
            int i=0;
            while(i<len)
            {
                if(dp[i]==0) return false;
                i++;
            }
            return true;
        }

    public static boolean canJumpFast(int[] nums) {

        //using greedy approach - always makes the choice that seems to be the best at that moment.
            int lastValidIndex = nums.length-1;

            for(int i=nums.length-1; i>=0; i--){
                if(i + nums[i] >= lastValidIndex){
                    lastValidIndex = i;
                }
        }

        return lastValidIndex == 0;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4};
        System.out.println(canJumpFast(a));
    }

}
