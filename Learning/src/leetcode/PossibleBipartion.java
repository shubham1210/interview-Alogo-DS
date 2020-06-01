package leetcode;

import java.util.*;

/**
 * Created by shubhamsharma on 2020-05-28.
 */
public class PossibleBipartion {
    private Map<Integer, Integer> visited = new HashMap<>();
    private ArrayList<Integer>[] graph;

    public boolean possibleBipartition(int N, int[][] dislikes) {

        graph = buildGraph(dislikes, N);

        for (int p = 1; p <= N; p ++)
        {
            if (!visited.containsKey(p))
            {
                if (!traverse(p, 0)) return false;
            }
        }
        return true;
    }

    private ArrayList<Integer>[] buildGraph(int[][] dislikes, int N)
    {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i ++) graph[i] = new ArrayList<>();
        for (int[] dislike : dislikes)
        {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        return graph;
    }

    private boolean traverse(Integer p, int color)
    {
        visited.put(p,color);

        color = color^1;
        ArrayList<Integer> ps = graph[p];
        for (Integer p0 : ps)
        {
            if (visited.containsKey(p0)&&visited.get(p0)!=color) return false;
            if (!visited.containsKey(p0))
            {
                if (!traverse(p0,color)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[][] = {{4,7},{4,8},{2,8},{8,9},{1,6},{5,8},{1,2},{6,7},{3,10},{8,10},{1,5},{7,10},{1,10},{3,5},{3,6},{1,4},{3,9},{2,3},{1,9},{7,9},{2,7},{6,8},{5,7},{3,4}};
        PossibleBipartion possibleBipartion = new PossibleBipartion();
        System.out.println(possibleBipartion.possibleBipartition(10,arr));
    }
}
