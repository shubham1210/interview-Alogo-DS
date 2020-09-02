package leetcode;

import leetcode.utils.Util;

import java.util.HashMap;

/**
 * Created by shubhamsharma on 2020-07-02.
 */
public class QurtyPermutaion {

        public int[] processQueries(int[] queries, int m) {
            int len =  queries.length;
            int[] result = new int[len];
            int resultIndex =0;
            HashMap<Integer,Integer> mapByValue = new HashMap<Integer,Integer>(m);
            HashMap<Integer,Integer> mapByIndex = new HashMap<Integer,Integer>(m);
            for(int i=0;i<m;i++)
            {
                mapByValue.put(i+1,i);
                mapByIndex.put(i,i+1);
            }
            for(int i=0;i<len ;i++)
            {
                int indexOfValue = mapByValue.get(queries[i]);
                result[resultIndex] = indexOfValue;
                resultIndex++;

                increaseIndexby1(mapByValue,mapByIndex,indexOfValue-1);
                mapByValue.put(queries[i],0);
                mapByIndex.put(0,queries[i]);
            }

            return result;

        }


    public void increaseIndexby1(HashMap<Integer,Integer> mapByValue,HashMap<Integer,Integer> mapByIndex, int fromWhereIndex){
        while(fromWhereIndex>=0)
        {
            int numberValue = mapByIndex.get(fromWhereIndex);
            mapByIndex.remove(fromWhereIndex);
            mapByIndex.put(fromWhereIndex+1,numberValue);

            //
            mapByValue.put(numberValue,mapByValue.get(numberValue)+1);
            fromWhereIndex--;

        }
    }

    public static void main(String[] args) {
        int a[] ={3,1,2,1};
        QurtyPermutaion qurtyPermutaion = new QurtyPermutaion();
        Util.printArray(qurtyPermutaion.processQueries(a,5));
    }

}
