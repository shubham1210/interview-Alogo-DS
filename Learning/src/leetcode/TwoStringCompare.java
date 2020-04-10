package leetcode;


import java.util.Stack;

public class TwoStringCompare {
    /*public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        int i = 0;
        while (i < S.length()) {
            if (S.charAt(i) == '#') {
                if (stack.size() > 0)
                    stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
            i++;
        }
        i =0;

        while (i < T.length()) {
            if (T.charAt(i) == '#') {
                if (stack2.size() > 0)
                    stack2.pop();
            } else {
                stack2.push(T.charAt(i));
            }
            i++;
        }
        return isSameStack(stack, stack2);
    }

    static boolean isSameStack(Stack<Character> stack1, Stack<Character> stack2) {
        // Create a flag variable
        boolean flag = true;

        // Check if size of both stacks are same
        if (stack1.size() != stack2.size()) {
            flag = false;
            return flag;
        }

        // Until the stacks are not empty
        // compare top of both stacks
        while (stack1.empty() == false) {
            // If the top elements of both stacks
            // are same
            if (stack1.peek() == stack2.peek()) {
                // Pop top of both stacks
                stack1.pop();
                stack2.pop();
            } else {
                // Otherwise, set flag to false
                flag = false;
                break;
            }
        }

        // Return flag
        return flag;
    }*/

    public static boolean  backspaceCompare(String S, String T) {
        if (S.isEmpty() && T.isEmpty()) {
            return true;
        }
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (true) {
            i = applyBackSpace(S, i);
            j = applyBackSpace(T, j);
            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0 || S.charAt(i--) != T.charAt(j--)) {
                return false;
            }
        }
    }

    private static int applyBackSpace(String str, int i) {
        int count = 0;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                count++;
            } else if (count > 0) {
                count--;
            } else if (count == 0) {
                break;
            }
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##","c#d#"));;
    }

}
