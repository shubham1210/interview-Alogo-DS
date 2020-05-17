package leetcode;

public class DivideTwoIntgerWithoutOperator {


/* public int divide(int dividend, int divisor) {


        int signdividend = dividend<0?-1:1;
        int signdivisor = divisor<0?-1:1;

        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);

        long q=0;
        while(dividendL>=divisorL &&  (dividendL <= 2147483647 || dividendL >=  -2147483648))
        {
            dividendL-= divisorL;
            q++;
        }

        if(q > 2147483647)
            q= 2147483647;
        else if(q < -2147483648)
            q = -2147483648;

        return (int)q*signdividend*signdivisor;
    }*/

    public static int divide(int dividend, int divisor) {

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend); // as boundry numbers cannot be fit into the the range like -2147483648 turns to 2147483648 that cant fit to integer due to range
        long absDivisor = Math.abs((long) divisor);
        long result =0; // we need to make it long to handle lo
        while(absDividend>=absDivisor){ // looks like it will max 2 times. incase boundy condition make it less then this will run again.
            long temp = absDivisor;long count=1; // event count need to be long to handle it as boundy condtion will fail

            while(temp<=absDividend){
                temp<<=1; // multipy by 2pow(1) , so << opertaor is multiplication of 2 pow(1) , 1 is right side to the operator
                count<<=1;
            }

            result+=count>>1; // in case last operation make it bigger.
            absDividend -= temp>>1; // it should keep subtracting the absDividend to amount what we have proceesed

        }

        return  isNegative ? (int)~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE :(int)result;

    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648
                ,-1));;
    }
}
