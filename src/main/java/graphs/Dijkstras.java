package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstras {

  private static final int inf = Integer.MAX_VALUE;
  private static int n;
  private static List<List<Pair>> adjList;
  private static int[] d;
  
  /*
   * Time complexity: O(n^2)
   */
  private static void dijkstras(int v) {
    d = new int[n];
    Arrays.fill(d, inf);
    boolean[] vis = new boolean[n];
    d[v] = 0;
    int u, min;
    while(true) {
      min = inf;
      u = -1;
      for(int i=0; i<n; i++) {
        if(!vis[i] && min >= d[i]) {
          min = d[i];
          u = i;
        }
      }
      if(u == -1)
        break;
      vis[u] = true;
      for(Pair p : adjList.get(u)) {
        if(d[p.first] > d[u] + p.second)
          d[p.first] = d[u] + p.second;
      }
    }
  }
  
  /*
   *  
   */
  private static void dijkstras1(int v) {
    d = new int[n];
    Arrays.fill(d, inf);
    d[v] = 0;
    boolean[] vis = new boolean[n];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(v, d[v]));
    while(!pq.isEmpty()) {
      Pair c = pq.poll();
      if(vis[c.first]) continue;
      vis[c.first] = true;
      for(Pair p : adjList.get(c.first)) {
        if(d[p.first] > d[c.first] + p.second) {
          d[p.first] = d[c.first] + p.second;
          pq.add(new Pair(p.first, d[p.first]));
        }
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    adjList = new ArrayList<>();
    int m;
    for(int i=0; i<n; i++) {
      m = sc.nextInt();
      List<Pair> list = new ArrayList<>();
      for(int j=0; j<m; j++) {
        int vertex = sc.nextInt();
        int weight = sc.nextInt();
        list.add(new Pair(vertex, weight));
      }
      adjList.add(list);
    }
    //dijkstras(0);
    dijkstras1(0);
    for(int i=0; i<n; i++) {
      System.out.print(d[i] + " ");
    }
    System.out.println("");
    sc.close();
  }
  
  private static class Pair implements Comparable<Pair>{
    int first;
    int second;
    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
    
    @Override
    public int compareTo(Pair p) {
      return this.second > p.second ? 1 : this.second < p.second ? -1 : 0;
    }
  }
}
