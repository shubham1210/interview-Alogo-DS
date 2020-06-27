package leetcode;

import leetcode.utils.Util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by shubhamsharma on 2020-06-27.
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervalPath {

    // this will sort the list on the base of first element in the set so all set will be placed in increasing order of the first element.
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }

    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        LinkedList<int[]> merged =  new LinkedList();

        for(int[] a : intervals){

            if(merged.isEmpty() || merged.getLast()[1] < a[0]){
                merged.add(a);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], a[1]);
            }

        }

        return merged.toArray(new int[merged.size()][]);

    }

    public static void main(String[] args) {
        //int a[][] ={{1,3},{2,6},{8,10},{15,18}};
        int a[][] ={{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};

        MergeIntervalPath mergeIntervalPath = new MergeIntervalPath();

        Util.print2DArray(mergeIntervalPath.merge(a));

    }
}
