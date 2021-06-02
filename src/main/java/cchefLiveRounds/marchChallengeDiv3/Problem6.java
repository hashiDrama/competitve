/*
 * https://www.codechef.com/MARCH21C/problems/DENSEGRP
 */
package cchefLiveRounds.marchChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem6 {

  private static List<List<Pair>> adjList;
  private static int n;
  private static final int inf = Integer.MAX_VALUE;

  private static int dijkstras(int u, int dest) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean[] vis = new boolean[n];
    int[] d = new int[n];

    Arrays.fill(d, inf);
    d[u] = 0;
    pq.add(new Pair(u, d[u]));
    Pair curr;

    while (!pq.isEmpty()) {
      curr = pq.poll();
      if (vis[curr.v])
        continue;
      vis[curr.v] = true;
      for (Pair p : adjList.get(curr.v)) {
        if (d[p.v] > d[curr.v] + p.d) {
          d[p.v] = d[curr.v] + p.d;
          pq.add(new Pair(p.v, d[p.v]));
        }
      }
    }
    return d[dest] == inf ? -1 : d[dest];
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    String line = fr.nextLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      String[] data = fr.nextLine().split(" ");
      n = Integer.parseInt(data[0]);
      int m = Integer.parseInt(data[1]);
      int x = Integer.parseInt(data[2]);
      int y = Integer.parseInt(data[3]);

      int[] a = new int[m];
      int[] b = new int[m];
      int[] c = new int[m];
      int[] d = new int[m];

      for (int i = 0; i < m; i++) {
        data = fr.nextLine().split(" ");
        a[i] = Integer.parseInt(data[0])-1;
        b[i] = Integer.parseInt(data[1])-1;
        c[i] = Integer.parseInt(data[2])-1;
        d[i] = Integer.parseInt(data[3])-1;
      }

      // create graph
      adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
      }
      for (int i = 0; i < m; i++) {
        for (int j = a[i]; j <= b[i]; j++) {
          for (int k = c[i]; k <= d[i]; k++) {
            adjList.get(j).add(new Pair(k, 1));
          }
        }
      }
      // graph creation done

      System.out.println(dijkstras(x - 1, y - 1));
    }
  }

  private static class Pair implements Comparable<Pair> {
    int v;
    int d;

    public Pair(int v, int d) {
      this.v = v;
      this.d = d;
    }

    @Override
    public int compareTo(Pair p) {
      return Integer.compare(this.d, p.d);
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
