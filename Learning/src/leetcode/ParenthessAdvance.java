package leetcode;

import java.util.Stack;

public class ParenthessAdvance {

    public static boolean checkValidString(String s) {
        int i = 0;
        int max_open_left = 0, min_open_left = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c == '('){
                min_open_left++;
            }
            else if (min_open_left > 0) {
                min_open_left--;
            }

            if (c != ')') {
                max_open_left++;
            } else if (max_open_left == 0) {
                return false;
            } else max_open_left--;
        }
        return min_open_left == 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
    }
}
