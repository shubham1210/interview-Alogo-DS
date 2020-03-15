package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Parentheses {

    public static boolean isValid(String s1) {

        Stack<Character> s = new Stack<Character>();
        boolean result =true;
        if(s1.length()==0)return true;
        if(s1==null || s1.length()<2) return false;
        for(int i=0;i<s1.length();i++)
        {
            char a = s1.charAt(i);
            if(a=='(' || a=='{' || a=='[')
                s.push(a);
            else if(s.size()>0){
                switch(a){
                    case ')':
                        if(s.size()>0 && s.pop() != '(')
                        {
                            result =false;break;
                        }else break;
                    case ']':
                        if(s.size()>0&& s.pop() != '[')
                        {
                            result =false;break;
                        }else break;
                    case '}':
                        if(s.size()>0&& s.pop() != '{')
                        {
                            result =false;break;
                        }else break;
                    default :
                        if(s.size()>0)
                        {
                            s.pop() ;
                            result =false;break;
                        }
                }
            }else{
                result =false;break;
            }
            if(result==false)break;
        }
        if(s.size()>0)result=false;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[])"));
    }
}
