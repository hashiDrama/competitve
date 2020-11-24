/*
 * uva-10369; link ->
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1310
 */

package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ArcticNetwork {

  private static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static class Edge implements Comparable<Edge> {
    int from;
    int to;
    double w;

    public Edge(int from, int to, double w) {
      this.from = from;
      this.to = to;
      this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
      return this.w < e.w ? -1 : this.w > e.w ? 1 : 0;
    }

    @Override
    public String toString() {
      return this.from + ", " + this.to + ", " + this.w;
    }
  }

  public static double kruskals(List<Edge> adjList, List<Edge> edges) {
    int n = adjList.size();
    PriorityQueue<Edge> q = new PriorityQueue<>();
    for (Edge e : adjList)
      q.add(e);
    DisjointSet ds = new DisjointSet(n);
    double minCost = 0.0;
    while (!q.isEmpty()) {
      Edge e = q.poll();
      if (ds.union(e.from, e.to)) {
        edges.add(e);
        minCost += e.w;
      }
    }
    return minCost;
  }

  private static double findDistance(Node from, Node to) {
    return Math.sqrt(Math.pow((double) (from.x - to.x), 2) + Math.pow((double) (from.y - to.y), 2));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int s = sc.nextInt();
      int p = sc.nextInt();
      List<Node> outposts = new ArrayList<>();
      for (int i = 0; i < p; i++) {
        outposts.add(new Node(sc.nextInt(), sc.nextInt()));
      }
      List<Edge> adjList = new ArrayList<>();
      for (int i = 0; i < p - 1; i++) {
        Node from = outposts.get(i);
        for (int j = i + 1; j < p; j++) {
          Node to = outposts.get(j);
          adjList.add(new Edge(i, j, findDistance(from, to)));
        }
      }
      List<Edge> edges = new ArrayList<>();
      kruskals(adjList, edges);
      int i = edges.size() - 1;
      while (s > 0) {
        i--;
        s -= 2;
      }
      System.out.println(edges.get(i).w);
    }
    sc.close();
  }

  private static class DisjointSet {
    int count;
    int[] parent;
    int[] rank;

    public DisjointSet(int count) {
      this.count = count;
      this.parent = new int[this.count];
      this.rank = new int[this.count];
      for (int i = 0; i < this.count; i++) {
        this.parent[i] = i;
        this.rank[i] = 1;
      }
    }

    public int find(int i) {
      if (parent[i] == i)
        return i;
      parent[i] = find(parent[i]);
      return parent[i];
    }

    public boolean union(int i, int j) {
      int irep = find(i);
      int jrep = find(j);
      if (irep == jrep)
        return false;
      int irank = rank[irep];
      int jrank = rank[jrep];
      if (irank > jrank) {
        parent[jrep] = irep;
      } else if (irank == jrank) {
        rank[jrep]++;
      }
      parent[irep] = jrep;
      return true;
    }
  }

}
