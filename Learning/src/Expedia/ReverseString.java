package Expedia;

/**
 * Created by shubhamsharma on 12/1/2015.
 */
public class ReverseString {

    public static void main(String[] a)
    {
        reverseString("As I pee, sir, I see Pisa!");
    }

    public static void  reverseString(String s)
    {
        int start = 0;
        int end = s.length()-1;
        char array[] = s.toCharArray();
        char temp;
        while (end>start)
        {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            end--;
            start++;
        }
        System.out.println("original == "+s);
        System.out.println("reverse == "+new String(array));
    }

    public void a()
    {

    }
}
