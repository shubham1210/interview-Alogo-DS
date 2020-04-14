package leetcode;

import java.util.HashMap;

public class RomanConverter {

    public static int romanToInt(String s) {

        char[] sa = s.toCharArray();

        int i = sa.length-1;

        HashMap<Character,Integer> map =  new HashMap();

        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);
        map.put('C',100);map.put('D',500);map.put('M',1000);

        char last =' ';
        int ans=0;

        while(i>=0)
        {
            if(last==' ')
            {
                last = sa[i];
                ans = map.get(sa[i]);
            }else{
                if(map.get(last) > map.get(sa[i]))
                {
                    ans-=map.get(sa[i]);

                }else if(map.get(last) <= map.get(sa[i]))
                {
                    ans+=map.get(sa[i]);
                }
                last = sa[i];
            }

            i--;
        }

        return ans;

    }

    public static void main(String[] args) {
        romanToInt("LVIII");
    }
}
