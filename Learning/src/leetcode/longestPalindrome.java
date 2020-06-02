package leetcode;

/**
 * Created by shubhamsharma on 2020-03-11.
 https://leetcode.com/problems/longest-palindromic-substring/submissions/
 https://www.youtube.com/watch?v=DK5OKKbF6GI
 */
public class longestPalindrome {

    int resultMaxLen = 0;
    int resultStart=0;
    public String longestPalindrome(String s) {

        int len =  s.length();
        if(len<2) return s;
        for(int i=0;i<len-1;i++)
        {
            isPalindrome(s,i,i);// this will work for if the string legth of even
            isPalindrome(s,i,i+1);// if string legth is odd then we can have 2 midpoints.

        }

        return s.substring(resultStart,resultStart+resultMaxLen);
    }

    public void isPalindrome(String s, int start, int end)
    {
        int len = s.length();

        while(start>=0 && end<len && s.charAt(start)==s.charAt(end))
        {
            start--; // we are expanding boundry to left by subtracting it  by -1;
            end++; // we are expending boundry to  right by adding end to +1;
        }

        if(resultMaxLen< end-(start+1))
        {
            resultMaxLen = end-(start+1); // as start will be goint till 0 and -1 it broke from above rule we need to add 1
            resultStart = start+1; //as start has moved to left when it exit the loop
        }

    }
    public static void  main(String[] a)
    {
        longestPalindrome a1 = new longestPalindrome();
        //System.out.println(a1.longestPalindrome("babad")); // for odd length palindrome
        System.out.println(a1.longestPalindrome("ac")); // for single value palindrome

    }
}
