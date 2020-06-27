package leetcode;

/**
 * Created by shubhamsharma on 2020-06-27.
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePathOfEnd {
    int noofWays=0;
    public static int uniquePaths(int m, int n) {
        /*noofWays =0;
        recursion(m-1 , n-1 , 0, 0);
        return noofWays;*/

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0)
                    dp[i][j] =1;
                else{
                    dp[i][j] =  dp[i-1][j] +  dp[i][j-1];
                }
            }
        }

        return  dp[m-1][n-1];

    }


    public void recursionTimeoutButFine(int row , int col , int currentRow, int currentCol)
    {

        if(currentRow == row && currentCol == col)
        {
            noofWays++;
            return;
        }
        if(currentRow<row)
            recursionTimeoutButFine(row , col , currentRow+1, currentCol);
        if(currentCol<col)
            recursionTimeoutButFine(row , col , currentRow, currentCol+1);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));;
    }
}
