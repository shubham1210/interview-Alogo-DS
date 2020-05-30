package leetcode;

import java.util.ArrayList;
//https://www.youtube.com/watch?v=kXy0ABd1vwo&t=20s
//https://www.programcreek.com/2014/05/leetcode-course-schedule-java/
public class CourseScheduleGraph {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length==0) return true;
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        //ArrayList<Integer>[] al = new ArrayList[n];

        for(int i=0;i<prerequisites.length;i++)
        {
            if(adj[prerequisites[i][0]]==null)
                adj[prerequisites[i][0]] =  new ArrayList<Integer>();
            adj[prerequisites[i][0]].add(prerequisites[i][1]); // so each index is cource will keep its next course value
        }

        int visited[] = new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==0)
            {
                if(isCycle(adj,visited,i))
                {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isCycle(ArrayList<Integer> adj[], int[] visited, int curr)
    {
        if(visited[curr]==2)
            return true; // note is processed and it just came back
        visited[curr] = 2;


        for(int i=0;adj[curr]!=null && i<adj[curr].size();i++) // as some of the list is not assigned adj[curr]!=null
        {
            if(visited[adj[curr].get(i)]!=1) // that means it is not processed.
            {
                if(isCycle(adj,visited,adj[curr].get(i)))
                    return true; //cycle detected
            }
        }
        visited[curr]=1;
        return false;
    }
    public static void main(String[] args) {
        CourseScheduleGraph courseScheduleGraph = new CourseScheduleGraph();
        //int arr[][]  = {{1,0},{0,1}};
        //int arr[][]  = {{1,0}};
        int arr[][]  = {{0,1}};
        //int arr[][]  = {};
        System.out.println(courseScheduleGraph.canFinish(2,arr));
    }
}
