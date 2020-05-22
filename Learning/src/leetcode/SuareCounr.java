package leetcode;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
 */
public class SuareCounr {

    public static int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] s = new int[row][col];
        int count =0;
        for(int i=0;i<row;i++)
        {
            s[i][0] = matrix[i][0];
            if(s[i][0]==1)count++;
        }

        for(int i=1;i<col;i++) //as one is already processed in above loop
        {
            s[0][i] = matrix[0][i];
            if(s[0][i]==1)count++;
        }


        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(matrix[i][j]==1){
                    s[i][j] = Math.min( s[i-1][j-1],Math.min( s[i-1][j], s[i][j-1])) +1; // 1 for element itself

                    count+= s[i][j] ;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int a[][] = {{1,0,1},{1,1,0},{1,1,0}};
        System.out.println(countSquares(a));
    }
}
