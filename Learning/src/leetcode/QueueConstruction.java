package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueConstruction {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();
        for(int[] person : people){
            res.add(person[1],person);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(reconstructQueue(people));;
    }
}
