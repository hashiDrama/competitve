// uva-10147 ; link -> https://onlinejudge.org/external/101/10147.pdf

package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Highways {

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
    public String toString() {
      return "from=" + (this.from + 1) + ", to=" + (this.to + 1) + ", weight=" + this.w;
    }

    @Override
    public int compareTo(Edge e) {
      return this.w < e.w ? -1 : this.w > e.w ? 1 : 0;
    }
  }
  
  private static class DisjointSetDataStructure {

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

  static double prims(List<List<Edge>> adjList, List<Edge> edges) {
    int n = adjList.size();
    double minWeight = 0.0;
    boolean[] vis = new boolean[n];
    PriorityQueue<Edge> q = new PriorityQueue<>();
    q.add(new Edge(-1, 0, 0));

    while (!q.isEmpty()) {
      Edge e = q.poll();
      if (vis[e.to])
        continue;
      vis[e.to] = true;
      minWeight += e.w;
      if (e.to != 0) {
        boolean found = false;
        for (Edge ed : edges) {
          if ((ed.from == e.from && ed.to == e.to) || (ed.from == e.to && ed.to == e.from)) {
            found = true;
            break;
          }
        }
        if (!found)
          edges.add(e);
      }

      for (int i = 0; i < adjList.get(e.to).size(); i++) {
        Edge ne = adjList.get(e.to).get(i);
        if (!vis[ne.to]) {
          q.add(ne);
        }
      }
    }
    return minWeight;
  }

  // Kruskals using priorityqueue and disjoint-set data-structure
  public static double kruskals(List<List<Edge>> adjList, List<Edge> edges,
      DisjointSetDataStructure ds) {
    int n = adjList.size();
    PriorityQueue<Edge> q = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      for (Edge e : adjList.get(i)) {
        q.add(e);
      }
    }
    double mstValue = 0.0;
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

  static double findWeight(Node n1, Node n2) {
    return Math.sqrt(Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      sc.nextLine();
      int n = sc.nextInt();
      List<Node> towns = new ArrayList<>();
      int x, y;
      for (int i = 0; i < n; i++) {
        x = sc.nextInt();
        y = sc.nextInt();
        towns.add(new Node(x, y));
      }
      List<List<Edge>> adjList = new ArrayList<>();
      int m = sc.nextInt();
      int from, to;
      List<Edge> edges = new ArrayList<>();

      DisjointSetDataStructure ds = new DisjointSetDataStructure(n);
      for (int i = 0; i < m; i++) {
        from = sc.nextInt();
        to = sc.nextInt();
        ds.union(from - 1, to - 1);
      }
      for (int i = 0; i < n; i++) {
        List<Edge> tEdges = new ArrayList<>();
        for (int j = i + 1; j < n; j++) {
          if (j != i) {
            tEdges.add(new Edge(i, j, findWeight(towns.get(i), towns.get(j))));
          }
        }
        adjList.add(tEdges);
      }
      // prims(adjList, edges);
      kruskals(adjList, edges, ds);
      if (edges.isEmpty()) {
        System.out.println("No new highways need");
      } else {
        for (int i = 0; i < edges.size(); i++) {
          System.out.println((edges.get(i).from + 1) + " " + (edges.get(i).to + 1));
        }
      }
      if (t != 0)
        System.out.println("");
    }
    sc.close();
  }
}
