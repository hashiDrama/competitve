/*
 * uva-10600,
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1541
 */

package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AcmContestAndBlackout {

  private static class Edge implements Comparable<Edge> {
    int from;
    int to;
    int w;

    public Edge(int from, int to, int w) {
      this.from = from;
      this.to = to;
      this.w = w;
    }

    @Override
    public String toString() {
      return "from=" + this.from + ", to=" + this.to + ", weight=" + this.w;
    }

    @Override
    public int compareTo(Edge e) {
      return this.w < e.w ? -1 : this.w > e.w ? 1 : 0;
    }
  }

  static int mst(List<Edge> edgeList, int n, List<Edge> edges) {
    DisjointSetDataStructure ds = new DisjointSetDataStructure(n);
    PriorityQueue<Edge> q = new PriorityQueue<>();
    for (Edge e : edgeList) {
      q.add(e);
    }
    int mstValue = 0;
    while (!q.isEmpty()) {
      Edge e = q.poll();
      if (ds.union(e.from, e.to)) {
        edges.add(e);
        mstValue += e.w;
      }
    }
    if(edges.size() != n-1) {
      edges = new ArrayList<>();
      return Integer.MAX_VALUE; 
    }
    return mstValue;
  }

  static int mst2(List<Edge> edgeList, int n, List<Edge> edges, int mst) {
    int mst2 = Integer.MAX_VALUE;
    for (int i = 0; i < edges.size(); i++) {
      Edge e = edges.get(i);
      edgeList.remove(e);
      List<Edge> nList = new ArrayList<>();
      mst2 = Math.min(mst2, mst(edgeList, n, nList));
      edgeList.add(e);
    }
    return mst2;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int ne = sc.nextInt();

      List<Edge> edgeList = new ArrayList<>();
      for (int i = 0; i < ne; i++) {
        edgeList.add(new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
      }
      List<Edge> edges = new ArrayList<>();
      int mst1 = mst(edgeList, n, edges);
      int mst2 = mst2(edgeList, n, edges, mst1);
      System.out.println(mst1 + " " + mst2);
    }
    sc.close();
  }

  static class DisjointSetDataStructure {

    int forests;
    int[] parent;
    int[] rank;

    public DisjointSetDataStructure(int n) {
      this.forests = n;
      this.parent = new int[this.forests];
      this.rank = new int[this.forests];
      for (int i = 0; i < this.forests; i++) {
        parent[i] = i;
        rank[i] = 1;
      }
    }

    public int find(int i) {
      if (this.parent[i] == i)
        return i;
      int rep = find(parent[i]);
      this.parent[i] = rep;
      return rep;
    }

    public boolean union(int i, int j) {
      int irep = this.find(i);
      int jrep = this.find(j);
      if (irep == jrep)
        return false;
      int irank = rank[irep];
      int jrank = rank[jrep];
      if (irank > jrank)
        this.parent[jrep] = irep;
      else if (irank < jrank)
        this.parent[irep] = jrep;
      else {
        this.parent[irep] = jrep;
        rank[jrep]++;
      }
      return true;
    }
  }
}


