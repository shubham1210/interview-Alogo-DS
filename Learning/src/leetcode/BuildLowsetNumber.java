package leetcode;

import java.util.Stack;

public class BuildLowsetNumber {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack();

        if(num.length()==k ) return "0";
        int i=0;
        for(char c : num.toCharArray())
        {
            //whenever we have element that is in stack greater than current element we should delete it is keeping all elment from left to right and left value will
            //always have more value to make number bigger.
            while (!st.isEmpty() && k>0 && st.peek()>c)
            {
                st.pop();k--;
            }
            //!st.isEmpty() it is placed to add zero in special case like when stack is not empty and still some Zero are coming that means taling zero is needed.
            if(!st.isEmpty() || c!='0'){
                st.push(c);
            }
        }
        //this is when you have stituation alike most the number in asc order then kcan never be zero 123456789 then you need to remove it from the right.
        while(k!=0 && st.isEmpty()==false)
        {
            st.pop();
            k--;
        }

       if(st.isEmpty())
            return "0";

       String result="";
        while (!st.isEmpty())
        {
            result=st.pop()+result;
        }
        return result;
    }
    public static void main(String[] args) {
        BuildLowsetNumber buildLowsetNumber = new BuildLowsetNumber();
        //System.out.println(buildLowsetNumber.removeKdigits("1234567890",9));
        System.out.println(buildLowsetNumber.removeKdigits("10200",1));

    }
}
