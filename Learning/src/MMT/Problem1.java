package MMT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shubhamsharma on 10/7/2015.
 */
public class Problem1 {

    public static void main(String args[])
    {
        int a[]={1,2,5,-7,2,5,0,9,10};
        List<Integer> longestPositiveArray = new ArrayList<Integer>();
        List<Integer> finalLongestPositiveArray = new ArrayList<Integer>();
        int tempLastPositiveNo=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>tempLastPositiveNo)
            {
                longestPositiveArray.add(a[i]);
                tempLastPositiveNo = a[i];
            }
            else{
                tempLastPositiveNo = 0;
                validateAndInsert(finalLongestPositiveArray,longestPositiveArray);
                longestPositiveArray =  new ArrayList();
                if(a[i]>tempLastPositiveNo)
                {
                    longestPositiveArray.add(a[i]);
                    tempLastPositiveNo = a[i];
                }
            }
        }
        validateAndInsert(finalLongestPositiveArray,longestPositiveArray);
        System.out.println(finalLongestPositiveArray);
    }

    private static void validateAndInsert(List<Integer> finalLongestPositiveArray, List<Integer> longestPositiveArray)
    {
        if(finalLongestPositiveArray.size()==0)
            finalLongestPositiveArray.addAll(longestPositiveArray);
        else
        {
            if(finalLongestPositiveArray.size() < longestPositiveArray.size())
            {
                finalLongestPositiveArray.clear();
                finalLongestPositiveArray.addAll(longestPositiveArray);
            }
        }
    }
}
