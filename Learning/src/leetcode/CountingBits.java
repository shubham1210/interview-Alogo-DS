package leetcode;

public class CountingBits {

    //https://www.youtube.com/watch?v=awxaRgUB4Kw
    public int[] countBits(int num) {
        int[] ans = new int[num+1]; // as int can be of 32 bits
        ans[0] =0;
        for(int i=1;i<ans.length;i++){
            if(i%2==0)
                ans[i] = ans[i/2]; // so any number divide by 2 is just shifting of last bit in number so if it is even then zero is shifting then no impact in 1's bit to the last even number.
            else
                ans[i] = 1+ans[i/2]; // so any number divide by 2 is just shifting of last bit in number so if it is odd then 1 is shifting then we should consider 1 that is shifting extra to the last even number count of 1's.
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        for (int a : countingBits.countBits(5)){
            System.out.print(a +" ");
        }


    }
}
