package leetcode;
/*
https://leetcode.com/problems/wildcard-matching/
 */
public class RegexOperation {

    public static boolean isMatch(String str, String pattern) {

        int s =0 ; int p=0; int lastS =0 ; int lastP=-1;

        while(s<str.length())
        {
            if(p<pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p)))
            {
                s++;p++;
            }else if(p<pattern.length() && pattern.charAt(p) == '*'){
                lastP = p;
                lastS =s;
                p++; // p need to increase as the to check the next char after * should mactch with s
            }else if(lastP!=-1) //  that means we have found * last time before this iteration.
            {
                p = lastP+1;// so last p is not increasing. // it need to match with the next element in s.
                lastS++; // we need to keep increasing he s pointer till the time we dont get p and s equal
                s =lastS;
            }
            else return false;
        }
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p==pattern.length() ?true:false;
    }

    public static void main(String[] args) {
      System.out.println(isMatch("a","a*"));

        System.out.println(isMatch("aa","a*"));
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("acdcb","a*c?b"));
        System.out.println(isMatch("aaaa","***a"));
        System.out.println(isMatch("b","??"));
        System.out.println(isMatch("abefcdgiescdfimde","ab*cd?i*de"));
        ;
    }
}
