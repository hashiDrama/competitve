/*
 * SPOJ - INCARDS; link -> https://www.spoj.com/problems/INCARDS/
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InvitationCards {

  private static final int inf = 100000000;
  private static int[] d;
  private static int n;

  private static void dijkstras(int v, List<List<Pair>> adjList) {
    d = new int[n];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean[] vis = new boolean[n];
    Arrays.fill(d, inf);
    d[v] = 0;
    pq.add(new Pair(v, d[v]));
    while (!pq.isEmpty()) {
      Pair curr = pq.poll();
      if (vis[curr.first])
        continue;
      vis[curr.first] = true;
      for (Pair p : adjList.get(curr.first)) {
        if (d[p.first] > d[curr.first] + p.second) {
          d[p.first] = d[curr.first] + p.second;
          pq.add(new Pair(p.first, d[p.first]));
        }
      }
    }
  }

  public static void main(String[] args) {
    //Scanner sc = new Scanner(System.in);
    FastReader fr = new FastReader();
    int t = fr.nextInt();
    while (t-- > 0) {
      n = fr.nextInt();
      int e = fr.nextInt();
      List<List<Pair>> adjList1 = new ArrayList<>();
      List<List<Pair>> adjList2 = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList1.add(new ArrayList<>());
        adjList2.add(new ArrayList<>());
      }
      int from, to, w;
      for (int i = 0; i < e; i++) {
        from = fr.nextInt();
        to = fr.nextInt();
        w = fr.nextInt();
        adjList1.get(from - 1).add(new Pair(to - 1, w));
        adjList2.get(to - 1).add(new Pair(from - 1, w));
      }
      int sum = 0;
      dijkstras(0, adjList1);
      for (int i = 0; i < n; i++) {
        sum += d[i];
      }
      dijkstras(0, adjList2);
      for (int i = 0; i < n; i++) {
        sum += d[i];
      }
      System.out.println(sum);
    }
  }

  private static class Pair implements Comparable<Pair> {
    int first;
    int second;

    public Pair(int to, int w) {
      this.first = to;
      this.second = w;
    }

    @Override
    public int compareTo(Pair p) {
      return this.second > p.second ? 1 : this.second < p.second ? -1 : 0;
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

    double nextDouble() {
      return Double.parseDouble(next());
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
