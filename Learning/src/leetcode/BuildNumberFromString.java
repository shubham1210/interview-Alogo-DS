package leetcode;
/*
https://leetcode.com/problems/string-to-integer-atoi/
 */
public class BuildNumberFromString {
    public int myAtoi(String str) {

        str = str.trim();
        if(str.length()==0) return 0;
        //str = str.replaceAll(" ","");
        long result = 0;
        char b=  str.charAt(0);
        boolean isNeg=  b=='-'? true:false ;
        if(isNeg) str= str.substring(1);
        else if( b=='+')
            str= str.substring(1);

        for(char a : str.toCharArray())
        {
            if(isInt(a))
            {
                result = result*10+Integer.parseInt(a+"");
            }
            else
            {
                break;
            }

            if(result > Integer.MAX_VALUE)
            {
                break;
            }
        }
        if(isNeg && result > Integer.MAX_VALUE)
            result = Integer.MIN_VALUE;
        else if(!isNeg && result > Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;
        else if(isNeg)
            result = result*-1;

        return (int)result;
    }

    public boolean isInt(char a)
    {

        if(a>=48 && a<=57) return true;
        return false;
    }

    public static void main(String[] args) {
        BuildNumberFromString fromString = new BuildNumberFromString();
        fromString.myAtoi("9223372036854775808");
    }
}
