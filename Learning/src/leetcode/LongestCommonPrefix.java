package leetcode;

/**
 * Created by shubhamsharma on 2020-03-30.
 */
public class LongestCommonPrefix {

// this question is unclear about prefix means it must have fist char flowing if first char is not matched than return blank.
    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length==0) return "";
        String prefix = strs[0];
        
        for(int i=1;i<strs.length;i++)
        {
            // we are reducing down string till we dont get a macth with current string
           while( prefix.isEmpty()==false && strs[i].indexOf(prefix)!=0)
           {
               prefix = prefix.substring(0,prefix.length()-1);
           }
            
            if(prefix.isEmpty())
                return "";
        }
        
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        longestCommonPrefix(strs);
    }
}
