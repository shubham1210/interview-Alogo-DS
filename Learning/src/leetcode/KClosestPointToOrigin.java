package leetcode;

import java.util.PriorityQueue;

/**
 * Created by shubhamsharma on 2020-05-31.
 */
public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> (b[1]*b[1]+b[0]*b[0]) -  (a[1]*a[1]+a[0]*a[0]));

        for(int[] point :points)
        {
            maxHeap.add(point);
            if(maxHeap.size()>K)
            {
                maxHeap.remove();
            }
        }

        int[][] result = new int[K][2];

        while(K-->0)
        {
            result[K] = maxHeap.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        KClosestPointToOrigin origin = new KClosestPointToOrigin();

        int a[][] = {{1,3}, {-2,-2}};
        a = origin.kClosest(a,1);

        for (int[] a1 : a)
        {
            System.out.println(a1[0] + " "+a1[1]);
        }
    }

}
