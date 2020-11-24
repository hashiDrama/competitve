/*
 * SPOJ-HIGHWAYS; link -> https://www.spoj.com/problems/HIGHWAYS/
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Highways {

  private static final int inf = 2000;
  private static List<List<Pair>> adjList;
  private static int n;
  private static boolean[] vis;

  private static int dijkstras(int u, int v) {
    int[] d = new int[n];
    Arrays.fill(d, inf);
    d[u] = 0;
    PriorityQueue<Pair> q = new PriorityQueue<>();
    q.add(new Pair(u, d[u]));
    while (!q.isEmpty()) {
      Pair c = q.poll();
      if (vis[c.first])
        continue;
      vis[c.first] = true;
      for (Pair p : adjList.get(c.first)) {
        if (d[p.first] > d[c.first] + p.second) {
          d[p.first] = d[c.first] + p.second;
          q.add(new Pair(p.first, d[p.first]));
        }
      }
    }
    if (d[v] == inf) {
      return -1;
    }
    return d[v];
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int t = fr.nextInt();
    while (t-- > 0) {
      n = fr.nextInt();
      int m = fr.nextInt();
      int s = fr.nextInt();
      int e = fr.nextInt();
      adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
      }
      int from, to, time;
      for (int i = 0; i < m; i++) {
        from = fr.nextInt();
        to = fr.nextInt();
        time = fr.nextInt();
        adjList.get(from - 1).add(new Pair(to - 1, time));
        adjList.get(to - 1).add(new Pair(from - 1, time));
      }
      vis = new boolean[n];
      int shortestPath = dijkstras(s-1, e-1);
      if (shortestPath == -1)
        System.out.println("NONE");
      else
        System.out.println(shortestPath);
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
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
