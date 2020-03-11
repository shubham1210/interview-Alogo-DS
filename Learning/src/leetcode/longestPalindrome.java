package leetcode;

/**
 * Created by shubhamsharma on 2020-03-11.
 */
public class longestPalindrome {

    int resultStart;
    int resultLength;
    public String longestPalindrome(String s) {

        int j =s.length();
        if(s.length()<2) return s;

        for(int i=0;i<j-1;i++)
        {
            isPalin(s,i,i);
            isPalin(s,i,i+1);

        }
        return s.substring(resultStart,resultStart+resultLength);
    }

    public void isPalin(String s,int start, int end)
    {
        while(start>=0 && end< s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;end++;
        }

        if(resultLength<end-start-1)
        {
            resultLength = end-start-1;
            resultStart = start+1;
        }
    }

    public static void  main(String[] a)
    {
        longestPalindrome a1 = new longestPalindrome();
        System.out.println(a1.longestPalindrome("babad"));
    }
}
