package leetcode;

/**
 * Created by shubhamsharma on 2020-04-27.
 *
 * Example 1:

 Input: text1 = "abcde", text2 = "ace"
 Output: 3
 Explanation: The longest common subsequence is "ace" and its length is 3.
 Example 2:

 Input: text1 = "abc", text2 = "abc"
 Output: 3
 Explanation: The longest common subsequence is "abc" and its length is 3.
 Example 3:

 Input: text1 = "abc", text2 = "def"
 Output: 0
 Explanation: There is no such common subsequence, so the result is 0.

 https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3311/
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {

        char X[] = text1.toCharArray();
        char Y[] = text2.toCharArray();
        int m = X.length;
        int n = Y.length;
        //as we need to save 0,0 as 0 that why 1 more row col needed.
        int L[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // this is starting condition only call on time
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                    //this is if char mathces in string array then place +1 in final array .
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);

            }
        }
        return L[m][n];

    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("oxcpqrsvwf","shmtulqrypy"));

    }
}
