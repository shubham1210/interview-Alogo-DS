package leetcode;

public class CountSay {
    public static String countAndSay(int n) {

        String result ="1";
        if(n==1) return "1";
        // as for 1 is already calculated so process 1 less
        while(n>1)
        {
            String temp ="";
            int i=0;
            int count=1;
            //this is the main crux that need to be seen so each string we parse like this
            /*
            1
            11
            21
            1211
            111221
            312211 - it is calculated from previous step (1112211) 111-> 31(3 times 1) , 22 -> 22 (2 times 2), 1-> 11(1 times 1)
            13112221
             */
            while(i<result.length())
            {
                //see the number repeated
                while(i+1<result.length() && result.charAt(i) == result.charAt(i+1))
                {
                    count++;
                    i++;
                }
                // temp is holding the intermidate string like above comment 111-> 31(3 times 1) th
                temp+=count+""+ result.charAt(i);
                i++;
                // why count from 1 as each char must repeat by altleast 1
                count=1;
            }
            result = temp;
            n--;
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
