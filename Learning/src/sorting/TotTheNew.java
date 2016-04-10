package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by shubhamsharma on 12/10/2015.
 */
public class TotTheNew {

    public static void main(String[] a)
    {
        int[] input ={2,3,4,2,8,1,1,2};
        sort(input);
        /*for(int i=0;i<input.length;i++)
        {
            System.out.print(input[i] + " ");
        }*/
    }

    public static void sort(int[] inputArray)
    {
        Arrays.sort(inputArray);
        int countSort[][]= new int[inputArray.length][2];
        for(int i=0;i<inputArray.length;i++)
        {
            System.out.print(inputArray[i] + " ");
        }
        int count=1;
        int index=0;
        int countarray[]=new int[inputArray.length];
        TreeMap<Integer,Integer> counMap = new TreeMap<Integer, Integer>();
        for(int i=0;i<inputArray.length;i++)
        {
            if(i+1 < inputArray.length && inputArray[i] == inputArray[i+1])
                count++;
            else
            {
                counMap.put(inputArray[i],count);
                //if()
                count = 1;
                index++;
            }
        }
        System.out.println(counMap);


    }
}
