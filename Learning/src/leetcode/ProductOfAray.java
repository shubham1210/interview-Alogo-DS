package leetcode;

/**
 * so idea is to first iterate array from left to calculate left products and then fro right to include right element .
 */
class ProductOfAray {
    int[] productArray(int nums[])
    {

        int n = nums.length;
        if(n==1) return nums;
        int ans[] = new int[n];

        int i=0;

        //filling all up by 1 so that mutipply resultwont effect
        for(i=0;i< n ;i++)
        {
            ans[i] =1;
        }

        int temp =1; // initalise to 1 so that first element get assigned  by 1


        // this is left product.
        for(i=0;i<n;i++)
        {
            ans[i] = temp; // so for current elemnet the product should be last one, so placing from left.
            temp*= nums[i]; // mutiplying to store in to next position
        }

        temp =1;

        for(i=n-1;i>=0;i--)
        {
            ans[i]*=temp; // at last index it is mutilpy of all left so no need to change.
            temp*= nums[i];
        }

        return ans;
    }

    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        ProductOfAray pa = new ProductOfAray();
        int arr[] = { 1,2,3,4};
        System.out.println("The product array is : "+pa.productArray(arr));
    }
}


