/*
 * SPOJ- The Benefactor; link -> https://www.spoj.com/problems/BENEFACT/
 *Algo:
Since there is only one edge between every vertices, the problem is straightforwad.
1. bfs(dijkstras) on the graph from vertex 0 and store the vertices with maximum length from source.
2. bfs(dijkstras) from new source and return the maximum length from this bfs.
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TheBenefactor {

  private static final int inf = Integer.MAX_VALUE;

  private static List<List<Pair>> adjList;
  private static boolean[] vis;
  private static int[] d;
  private static int n;

  private static void bfs(int u) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    d = new int[n];
    vis = new boolean[n];
    Arrays.fill(d, inf);
    d[u] = 0;
    pq.add(new Pair(u, d[u]));
    Pair top;
    while (!pq.isEmpty()) {
      top = pq.poll();
      if (vis[top.first])
        continue;
      vis[top.first] = true;
      for (Pair p : adjList.get(top.first)) {
        if (d[p.first] > d[top.first] + p.second) {
          d[p.first] = d[top.first] + p.second;
          pq.add(new Pair(p.first, d[p.first]));
        }
      }
    }
  }


  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int t = fr.nextInt();
    while (t-- > 0) {
      n = fr.nextInt();
      adjList = new ArrayList<>();
      for(int i=0; i<n; i++)
        adjList.add(new ArrayList<>());
      int a, b, cost;
      for (int i = 0; i < n - 1; i++) {
        a = fr.nextInt() - 1;
        b = fr.nextInt() - 1;
        cost = fr.nextInt();
        adjList.get(a).add(new Pair(b, cost));
        adjList.get(b).add(new Pair(a, cost));
      }
      bfs(0);
      int max = Integer.MIN_VALUE, maxi=-1;
      for (int i = 0; i < n; i++)
        if (max < d[i]) {
          max = d[i];
          maxi = i;
        }
      bfs(maxi);
      for (int i = 0; i < n; i++)
        if (max < d[i]) {
          max = d[i];
        }
      System.out.println(max);
    }
  }

  private static class Pair implements Comparable<Pair> {
    int first;
    int second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(Pair p) {
      return this.second < p.second ? -1 : this.second > p.second ? 1 : 0;
    }

  }

  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
