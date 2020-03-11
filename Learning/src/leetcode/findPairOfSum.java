package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by shubhamsharma on 2020-03-11.
 */
public class findPairOfSum {

    public static void pairOfsum(int[] a,int sum)
    {
        HashSet complements = new HashSet();
        if(a!=null && a.length>1)
        {
            for (int elm :a)
            {
                int temp = sum-elm;

                if(complements.contains(temp))
                {
                    System.out.println("pair = {" + temp + " " + elm+"}");
                }

                complements.add(elm);
            }
        }
    }

    // Main to test the above function
    public static void main(String[] args)
    {
        int A[] = { 1, 4, 45, 6, 10, 8, 8 };
        int n = 16;
        pairOfsum(A, n);
    }
}
