package leetcode;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimetoBuyandSellStock {
    /*
       it is slow
       public int maxProfit(int[] prices) {
            int n =  prices.length;

            int maxProfit =0;
            int intermidation = 0;
           for(int i=0;i<n;i++ )
           {
               intermidation = prices[i];
               for(int j=i+1;j<n;j++)
               {
                   if(intermidation < prices[j])
                       intermidation = prices[j];
               }

               if(intermidation - prices[i] >  maxProfit)
                   maxProfit = intermidation-prices[i];
           }

            return maxProfit;
        }*/
    //2,4,1
    public int maxProfit(int[] prices) {
        int n =  prices.length;
        int smallest =Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<n;i++ )
        {
            if(prices[i]<smallest)
            {
                smallest =prices[i] ;
            }

            if(prices[i]-smallest > maxProfit)
                maxProfit = prices[i]-smallest ;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int a[] = {7,1,5,3,6,4};
        BestTimetoBuyandSellStock obj = new BestTimetoBuyandSellStock();
        System.out.println(obj.maxProfit(a));
    }
}
