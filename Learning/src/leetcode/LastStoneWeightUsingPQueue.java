package leetcode;

import java.util.*;

public class LastStoneWeightUsingPQueue {

    public static int lastStoneWeightUsingPQueue(int[] stones) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int ele:stones) {
            pQueue.offer(ele);
        }
        while(pQueue.size()>1)
        {
            int e = pQueue.poll()-pQueue.poll();
            pQueue.offer(e);
        }

        return pQueue.peek();

    }

    public static void main(String[] args) {
        int[] a = {2,2};
        System.out.println(lastStoneWeightUsingPQueue(a));
    }

}
