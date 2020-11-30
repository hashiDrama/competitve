/*
 * SPOJ - TRAFFICN; link -> https://www.spoj.com/problems/TRAFFICN/
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TrafficNetwork {

  private static final int inf = Integer.MAX_VALUE;

  private static int n, m, s, t;
  private static List<List<Pair>> adjList, revList;
  private static boolean[] vis;
  private static int[] d, d1;

  private static void dijkstras() {
    Arrays.fill(vis, false);
    Arrays.fill(d, inf);
    PriorityQueue<Pair> q = new PriorityQueue<>();
    d[s] = 0;
    q.add(new Pair(s, d[s]));
    while (!q.isEmpty()) {
      Pair p = q.poll();
      if (vis[p.first])
        continue;
      vis[p.first] = true;
      for (Pair ap : adjList.get(p.first)) {
        if (d[ap.first] > d[p.first] + ap.second) {
          d[ap.first] = d[p.first] + ap.second;
          q.add(new Pair(ap.first, d[ap.first]));
        }
      }
    }
  }

  private static void dijkstras1() {
    Arrays.fill(vis, false);
    Arrays.fill(d1, inf);
    PriorityQueue<Pair> q = new PriorityQueue<>();
    d1[t] = 0;
    q.add(new Pair(t, d1[t]));
    while (!q.isEmpty()) {
      Pair p = q.poll();
      if (vis[p.first])
        continue;
      vis[p.first] = true;
      for (Pair ap : revList.get(p.first)) {
        if (d1[ap.first] > d1[p.first] + ap.second) {
          d1[ap.first] = d1[p.first] + ap.second;
          q.add(new Pair(ap.first, d1[ap.first]));
        }
      }
    }
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int T = fr.nextInt();
    while (T-- > 0) {
      n = fr.nextInt();
      m = fr.nextInt();
      int k = fr.nextInt();
      s = fr.nextInt() - 1;
      t = fr.nextInt() - 1;
      adjList = new ArrayList<>();
      revList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
        revList.add(new ArrayList<>());
      }
      int from, to, length;
      for (int i = 0; i < m; i++) {
        from = fr.nextInt() - 1;
        to = fr.nextInt() - 1;
        length = fr.nextInt();
        adjList.get(from).add(new Pair(to, length));
        revList.get(to).add(new Pair(from, length));
      }
      vis = new boolean[n];
      d = new int[n];
      d1 = new int[n];
      dijkstras();
      dijkstras1();
      int min = d[t];
      for (int i = 0; i < k; i++) {
        from = fr.nextInt() - 1;
        to = fr.nextInt() - 1;
        length = fr.nextInt();
        min = Math.min(min, Math.min(d[from] + length + d1[to], d1[from] + length + d[to]));
      }
      if (min == inf)
        System.out.println(-1);
      else
        System.out.println(min);
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

    long nextLong() {
      return Long.parseLong(next());
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
