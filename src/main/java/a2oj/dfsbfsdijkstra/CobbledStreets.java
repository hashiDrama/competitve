/*
 * SPOJ - Cobbled Streets; link -> https://www.spoj.com/problems/CSTREET/
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CobbledStreets {

  private static List<Edge> edges;
  private static int n;

  private static long kruskals() {
    PriorityQueue<Edge> q = new PriorityQueue<>();
    DisjointSet ds = new DisjointSet(n);
    q.addAll(edges);
    Edge e;
    long mst = 0;
    while (!q.isEmpty()) {
      e = q.poll();
      if (ds.union(e.from, e.to)) {
        mst += e.w;
      }
    }
    return mst;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int p = sc.nextInt();
      n = sc.nextInt();
      int m = sc.nextInt();

      edges = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        edges.add(new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextLong()));
      }
      long cost = kruskals() * p;
      System.out.println(cost);
    }
    sc.close();
  }

  private static class Edge implements Comparable<Edge> {
    int from;
    int to;
    long w;

    public Edge(int from, int to, long w) {
      this.from = from;
      this.to = to;
      this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
      return this.w < e.w ? -1 : this.w > e.w ? 1 : 0;
    }
  }

  private static class DisjointSet {
    int n;
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
      this.n = n;
      this.parent = new int[n];
      this.rank = new int[n];
      for (int i = 0; i < n; i++) {
        this.parent[i] = i;
        this.rank[i] = 1;
      }
    }

    public int find(int i) {
      if (parent[i] == i)
        return i;
      return parent[i] = find(parent[i]);
    }

    public boolean union(int i, int j) {
      int irep = find(i);
      int jrep = find(j);
      if (irep == jrep)
        return false;
      int irank = rank[irep];
      int jrank = rank[jrep];
      if (irank > jrank)
        parent[jrep] = irep;
      else
        parent[irep] = jrep;
      if (irank == jrank)
        rank[jrep]++;
      return true;
    }
  }
}
