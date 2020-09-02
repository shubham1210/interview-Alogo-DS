package graph;

import java.util.*;

public class Graph {

  int v;
  LinkedList<Integer> adj[];

  Graph(int v)
  {
    this.v = v;
    adj = new LinkedList[v];
    for(int i=0;i<v;i++)
      adj[i] = new LinkedList<>();
  }

  void addEdge(int v, int w){
    adj[v].add(w);
  }

  void BFS(int node){

    boolean visited[] = new boolean[v];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(node);
    visited[node] =true;

    while(!queue.isEmpty()){

      int ele =  queue.poll();
      System.out.print(ele +" ");

      Iterator<Integer> i =  adj[ele].listIterator();

      while (i.hasNext())
      {
        int n = i.next();
        if(!visited[n]){
          queue.add(n);
          visited[n] =true;
        }
      }
    }

  }


  //node where you want to start
  void DFS(int node,boolean[] visited)
  {
    System.out.print(node +" ");
    Iterator<Integer> i = adj[node].listIterator();
    visited[node]=true;

    while (i.hasNext()){
      int n = i.next();
      if(!visited[n])
      {
        visited[n]=true;
        DFS(n,visited);
      }
    }

  }
  public static void main(String[] args) {
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal "+
      "(starting from vertex 2)");

    g.BFS(2);
    boolean visited[] = new boolean[4];
    System.out.println(" ");
    g.DFS(2,visited);
  }
}
