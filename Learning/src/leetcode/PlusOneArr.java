package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PlusOneArr {

        public static int[] plusOne(int[] digits) {


            int n = digits.length;
            for(int i=n-1; i>=0; i--) {
                if(digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }else{
                    digits[i] = 0;
                }
            }

            int[] newNumber = new int [n+1];
            newNumber[0] = 1;

            return newNumber;
        }
    public static void main(String[] args) {
        int a[] = new int[]{9,9,9,9,9,9,9,9,9,9};
            plusOne(a);
    }
}
