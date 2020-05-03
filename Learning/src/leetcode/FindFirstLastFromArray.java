package leetcode;

public class FindFirstLastFromArray{

    public static int[] searchRange(int[] nums, int target) {
        
        int end=nums.length;
        int result[] = new int[2];
        result[0] =-1; result[1]=-1;
        
        result[0] = binarySearch(nums,target,0,end,true);
        
        if(result[0]==-1) return result;
        
        result[1] = binarySearch(nums,target,result[0],end,false)-1;
       return result;
    }
    
    public static int binarySearch(int[] nums, int target,int low, int end,boolean left)
    {
        
        int index =-1;
        while(low<end)
        {
            int mid = (low+end)/2;
            // so why we kept it as left as in left we need to make sure we need to pick the left Most elment in the list so some times list division happen
            // such a way that both repeating element come at left list
            if(left)
            {
                if(nums[mid] ==  target)
                {
                    index = mid;
                    //whenever we are finding the element we are keep pushing end to mid so that we can still find the next occurence in left side
                    end = mid;
                }
                else if(nums[mid] < target)
                {
                    low = mid+1;
                }else if(nums[mid] > target){
                    end = mid;
                }    
            }else{
                if(nums[mid] ==  target)
                {
                    index = mid+1;
                    //whenever we are finding the element we are keep pushing low(left index) to mid+1 so that we can still find the next occurence in right side
                    low = mid+1;
                }
                else if(nums[mid] < target)
                {
                    low = mid+1;
                }else if(nums[mid] > target){
                    end = mid;
                }  
            }
            
        }
        
        return index;
        
    }
    public static void main(String[] args) {
        int a[] = {5,7,7,8,8,10};
        a = searchRange(a,8);
        System.out.println(a[0]);;System.out.println(a[1]);;
    }
}