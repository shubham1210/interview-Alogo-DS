package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalancedBracesPrint {
    static void _printParenthesis(char str[], int pos, int n, int open, int close,List<String > result)
    {
        if(close == n)
        {
            String s="";
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                s+=str[i];

            result.add(s);
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos+1, n, open, close+1,result);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos+1, n, open+1, close,result);
            }
        }
    }

    // Wrapper over _printParenthesis()
    static void printParenthesis(char str[], int n)
    {
        List<String> result = new ArrayList<>();
        if(n > 0)
            _printParenthesis(str, 0, n, 0, 0,result);
        System.out.println(result);
        return;
    }

    // driver program
    public static void main (String[] args)
    {
        int n = 3;
        char[] str = new char[2 * n];
        printParenthesis(str, n);
    }
}
