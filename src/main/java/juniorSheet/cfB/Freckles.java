// uva-10034 link:- https://onlinejudge.org/external/100/10034.pdf


package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import algorithms.graph.MST.DisjointSetDataStructure;

public class Freckles {

  static class Node {
    double x;
    double y;

    public Node(double x, double y) {
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
      return "from=" + this.from + ", to=" + this.to + ", weight=" + this.w;
    }

    @Override
    public int compareTo(Edge e) {
      return this.w < e.w ? -1 : this.w > e.w ? 1 : 0;
    }
  }

  // Kruskals using priorityqueue and disjoint-set data-structure
  public static double kruskals(List<List<Edge>> adjList, List<Edge> edges) {
    int n = adjList.size();
    PriorityQueue<Edge> q = new PriorityQueue<>();
    DisjointSetDataStructure ds = new DisjointSetDataStructure(n);
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
    return mstValue;
  }

  static double findWeight(Node from, Node to) {
    return Math.sqrt(Math.pow((from.x - to.x), 2) + Math.pow((from.y - to.y), 2));
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      sc.nextLine();
      int n = sc.nextInt();
      List<Node> vertices = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        vertices.add(new Node(x, y));
      }
      List<List<Edge>> adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        List<Edge> tEdges = new ArrayList<>();
        for (int j = 0; j < n; j++) {
          if (j != i) {
            tEdges.add(new Edge(i, j, findWeight(vertices.get(i), vertices.get(j))));
          }
        }
        adjList.add(tEdges);
      }
      List<Edge> edges = new ArrayList<>();
      double mst = kruskals(adjList, edges);
      System.out.format("%.2f", mst);
      if (t != 0)
        System.out.println();
    }
    sc.close();
  }
}
