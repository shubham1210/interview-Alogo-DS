package leetcode;

/**
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3312/
 */
public class MaximalSquare {


    public static int maximalSquare(int[][] matrix) {
        int rows = matrix.length;
        if(rows==0) return 0;
        int col = matrix[0].length;
        int largest =0;
        //initialze the array to look in to the past data proccessed with 1 more row and col as there are some test cases which has only 1*1
        int s[][] = new int[rows+1][col+1];

        // we started from 1 row and index as 0 row and col we took for extra value. and we made i <= rows becuase we need are lookin i-1 in main matrix and i index in dp matrix
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=col;j++)
            {
                //
                if(matrix[i-1][j-1]==1){
                    //check left,  diagnoal left and element above it from current position if anyone is 0 that means that cant make the matrix.
                    // if min is zer0 but element itself is 1 so adding one again
                    // why used Math.min 2 times dont confuse it only accept 2 params so i had to nested it.
                    s[i][j] = Math.min(s[i][j-1],Math.min(s[i-1][j],s[i-1][j-1]))+1;
                    if(largest< s[i][j] )
                        largest = s[i][j];
                }
            }
        }

        return largest*largest;

    }

    /*
    below soultio will work if we have matrix with atleast 2*2 as test cases are diffrent so we need to go for above solution and this is DP solution
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows==0) return 0;
        int col = matrix[0].length;
        int largest =0;
        //initialze the array to look in to the past data proccessed
        int s[][] = new int[rows][col];

        //copy first row becuase they can maximum make 1*1 matrix that is itself
        for(int i=0;i<rows;i++)
        {
            s[i][0] = matrix[i][0]=='1'?1:0;
        }
        //copy first col becuase they can maximum make 1*1 matrix that is itself
        for(int j=0;j<col;j++)
        {
            s[0][j] = matrix[0][j]=='1'?1:0;
        }

        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(matrix[i][j]=='1'){
                    //check left,  diagnoal left and element above it from current position if anyone is 0 that means that cant make the matrix.
                    // if min is zer0 but element itself is 1 so adding one again
                    // why used Math.min 2 times dont confuse it only accept 2 params so i had to nested it.
                    s[i][j] = Math.min(s[i][j-1],Math.min(s[i-1][j],s[i-1][j-1]))+1;
                    if(largest< s[i][j] )
                         largest = s[i][j];
                }
            }
        }

        return largest*largest;

    }*/

    /*
    how i started but this solution only look for atleast 2*2 solution
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length-1;
        if(rows<0) return 0;
        int col = matrix[0].length-1;
        System.out.println(rows);System.out.println(col);
        if(rows==0 && col==0){
            if(matrix[0][0]=='1') return 1;
            else if(matrix[0][0]=='0') return 0;
        }



        int result=0;
        for(int i=0;i<=rows;i++){
             for(int j=0;j<=col;j++){

                 if(matrix[i][j]=='1')
                 {
                     if(checkRightAndDown(matrix,i,j,rows,col) && isSquare(matrix,i,j+1,rows,col)){
                         result+=4;
                         j+=2;
                     }
                 }
             }
        }

        return result;

    }

    boolean checkRightAndDown(char[][] matrix , int i, int j,int rows, int col)
    {
        if(i>=rows || j>=col || i<0 || col<0) return false;

        if(i+1 <= rows && j+1 <= col)
        {
            if(matrix[i+1][j]=='1' && matrix[i][j+1]=='1') return true;
        }

        return false;
    }

    boolean isSquare(char[][] matrix , int i, int j,int rows, int col)
    {
        if(i>=rows || j>=col || i<0 || col<0) return false;

        if(j+1 <= col)
        {
            if(matrix[i+1][j]=='1') return true;
        }

        return false;
    }*/

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(maximalSquare(M));
    }
}
