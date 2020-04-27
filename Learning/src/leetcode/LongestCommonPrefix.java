package leetcode;

/**
 * Created by shubhamsharma on 2020-03-30.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            System.out.print(strs[i].indexOf(prefix));

            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        longestCommonPrefix(strs);
    }
}
