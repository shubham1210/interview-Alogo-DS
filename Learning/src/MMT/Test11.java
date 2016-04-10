package MMT;

import java.util.ArrayList;
import java.util.List;


public class Test11 {

    public static void main(String pk[]) {
        String str1 = "this is a test string";
        String str2 = "tist";

        //String output = "t stri";

        findShortestSubstring(str1, str2);

    }

    public static void findShortestSubstring(String str1, String str2) {

        String[] arr = str1.split("");
        int length = arr.length;
        int minPossibleLength = 0;
        List<Character> str2List = new ArrayList<Character>();
        for(char c : str2.toCharArray()) {
            str2List.add(c);
        }
        minPossibleLength = str2List.size();

        for (int i=minPossibleLength; i<length; i++) {  // 4-20
            for (int j=0; j<=(length-i+1); j++) {  // i-4>0-17; i-5>0-16; i-5>0-15;....;i-20>0-20
                String substr = findSubString(j, i, arr);
                if (containsAllChars(substr, str2)) {
                    System.out.println("WE GOT THE WINNER >>> " + substr);
                    return;
                }
            }
        }
        System.out.println("No match found!!");
    }

    public static String findSubString(int index, int parentIndex, String[] arr) {
        StringBuilder substr = new StringBuilder("");
        for (int k=index; ( (k<=(parentIndex+index-1)) && k<arr.length); k++) { // r1>0-3, 1-4, 2-5, 17-20;  ....
            substr.append(arr[k]);
        }
        return substr.toString();
    }

    public static boolean containsAllChars(String substr, String str2) {
        boolean flag = false;
        StringBuilder newStr = new StringBuilder(substr);
        char arr[] = str2.toCharArray();
        for (int i=0; i<arr.length; i++) {
            char ch = arr[i];
            int index = newStr.indexOf(String.valueOf(ch));
            if (index == -1) {
                return flag;
            } else {
                newStr.deleteCharAt(index);
            }
            if (i == (arr.length-1)) {
                flag = true;
            }
        }
        return flag;
    }




}