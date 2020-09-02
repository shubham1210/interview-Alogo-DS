package graph;

public class ShortestPath {


/*
weight should not be -ve so distance cant be negative
so other application where -ve can happen so it cant apply there.
 */
  void  dijkstra(int[][] graph,int start)
  {
    int V =  graph.length;
    int dist[] = new int[V];
    boolean set[] = new boolean[V];

    for(int i =0;i<V;i++)
    {
      dist[i] =Integer.MAX_VALUE;
      set[i] =false;
    }
    dist[start] = 0;

    for (int count=0;count<V-1;count++)
    {
      // this going to found the next smallest distance vertex index so that we can likely to update all the path from there.
      int u = minDistance(dist,set);
      // and marking that index as processed as we are noting go back to same index again.
      set[u]= true;
      // we need to update  dist[k] for less value if found that mean if we found shorter version lets go there.
      for(int v=0;v<V;v++)
        // so u and v should not be making loop so it should not be 0 and there should be a edege between them
      if(!set[v] && dist[u]!=Integer.MAX_VALUE && graph[u][v]!=0 && graph[u][v]+dist[u] < dist[v])
        dist[v]=graph[u][v]+dist[u];
    }

    printSolution(dist);
  }

  int minDistance(int[] dist,boolean[] set){
    int min = Integer.MAX_VALUE; int min_index =-1;

    for(int v=0;v<set.length;v++)
    {
      if(set[v] == false && dist[v]<=min){
        min = dist[v];
        min_index =v;
      }
    }
    return min_index;
  }
  // A utility function to print the constructed distance array
  void printSolution(int dist[])
  {
    System.out.println("Vertex \t\t Distance from Source");
    for (int i = 0; i < dist.length; i++)
      System.out.println(i + " \t\t " + dist[i]);
  }


  /*
  to see all path from all edges
   */
  void flyodWarShall(int[][] graph){
    int v = graph.length;
    int dist[][] = new int[v][v];

    for(int i=0;i<v;i++)
    {
      for(int j=0;j<v;j++){
        dist[i][j] =graph[i][j];
      }
    }

    //zero at any i,j means there is no slef loop.
    // INF , infinity means there is not edge or connection between them
    for(int k=0;k<v;k++)
    {
      // this loop make the matrix for each element
      for (int i=0;i<v;i++)
      {
        for(int j=0;j<v;j++){

          dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);

        }
      }
    }

    printSolutionFlyod(dist,9999);
  }
  void printSolutionFlyod(int dist[][],int INF) {
    System.out.println("The following matrix shows the shortest " +
      "distances between every pair of vertices");
    int V = dist.length;

    for (int i = 0; i < V; ++i) {
      for (int j = 0; j < V; ++j) {
        if (dist[i][j] == INF)
          System.out.print("INF ");
        else
          System.out.print(dist[i][j] + "   ");
      }
      System.out.println();
    }
  }


    // Driver method
  public static void main(String[] args)
  {
    /* Let us create the example graph discussed above */
    int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    ShortestPath t = new ShortestPath();
    t.dijkstra(graph, 0);

    int INF = 9999;
    int graph2[][] = { {0,   5,  INF, 10},
      {INF, 0,   3, INF},
      {INF, INF, 0,   1},
      {INF, INF, INF, 0}
    };

    t.flyodWarShall(graph2);

  }
}
