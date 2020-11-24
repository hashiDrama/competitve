//@formatter:off
/*
 * Implementation of Prims algorithm.
 * Pseudocode:
 * PrimsMst(G, start):
 * 1. add start to mst
 * 2. while mst.size != N
 * 3. for each vertex u in mst:
 * 4.   curr = u
 * 5.   for each vertex v in G.adj[u]
 * 6.       look for min edge such that no loop is formed
 * 7.   update global min, global min source and global min dest
 * 8. add new dest to mst
 * 9. print mst
 */
//@formatter:on

package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims {

  static class Edge implements Comparable<Edge> {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "from: " + (this.from + 1) + ", to: " + (this.to + 1) + ", weight: " + this.weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight < o.weight ? -1 : this.weight > o.weight ? 1 : 0;
    }
  }

  // Time complexity : O(V^2)
  static void primMst(int[][] adjMx, int start) {
    int n = adjMx.length;
    List<Integer> mstV = new ArrayList<>();
    List<Edge> mstE = new ArrayList<>();

    int gMinD, gMinS, gMinDest;
    int minD, minI, curr = start;
    mstV.add(curr);
    while (mstV.size() != n) {
      gMinD = Integer.MAX_VALUE;
      gMinDest = -1;
      gMinS = -1;
      for (int i = 0; i < mstV.size(); i++) {
        curr = mstV.get(i);
        minD = Integer.MAX_VALUE;
        minI = -1;
        for (int j = 0; j < adjMx[curr].length; j++) {
          if (minD > adjMx[curr][j] && !mstV.contains(j)) {
            minD = adjMx[curr][j];
            minI = j;
          }
        }
        if (minD != Integer.MAX_VALUE) {
          gMinD = minD;
          gMinS = curr;
          gMinDest = minI;
        }
      }
      if (gMinS == -1 || gMinDest == -1) // disjoint graph
        break;
      mstV.add(gMinDest);
      mstE.add(new Edge(gMinS, gMinDest, gMinD));
    }
    print(mstE);
  }

  // O(E*logV)
  static List<Edge> primMstUsingPriorityQ(List<List<Edge>> adjList) {
    int n = adjList.size();
    boolean[] vis = new boolean[n]; // boolean to mark the visited vertices
    List<Edge> edges = new ArrayList<>(); // final mst

    PriorityQueue<Edge> pq = new PriorityQueue<>(); // queue to sort the edges of all visited
                                                    // vertices
    pq.add(new Edge(-1, 0, 0)); // adding 0th vertex as destination

    while (!pq.isEmpty()) {
      Edge e = pq.poll(); // min edge among all edges of vertices in mst
      if (vis[e.to])
        continue; // if dest already visited, continue
      vis[e.to] = true; // mark the edge
      if (e.to != 0) {
        edges.add(e); // add edge to the final MST
      }

      // add all the adjacent edges of the dest of latest minimum edge of mst
      for (int i = 0; i < adjList.get(e.to).size(); i++) {
        Edge ne = adjList.get(e.to).get(i);
        if (!vis[ne.to])
          pq.add(ne);
      }
    }

    return edges;
  }


  static void print(List<Edge> mstE) {
    for (Edge e : mstE) {
      System.out.println(e.toString());
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    // int[][] adjMx = new int[n][n];
    // for (int i = 0; i < n; i++)
    // for (int j = 0; j < n; j++)
    // adjMx[i][j] = sc.nextInt();
    // primMst(adjMx, 0);

    List<List<Edge>> adjList = new ArrayList<>();
    // System.out.println("Enter no of vertices:");
    int n = sc.nextInt();
    // System.out.println("Start adding edges. Accepted format -> to weight");

    for (int i = 0; i < n; i++) {
      // System.out.println("Enter no fo edges for vertex: " + (i + 1));
      int m = sc.nextInt();
      // System.out.println("Add edges for " + (i + 1) + "th vertex:");
      List<Edge> edges = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        int to = sc.nextInt();
        int weight = sc.nextInt();
        edges.add(new Edge(i, to - 1, weight));
      }
      adjList.add(edges);
    }

    List<Edge> mst = primMstUsingPriorityQ(adjList);
    for (Edge e : mst) {
      System.out.println(e);
    }
    sc.close();
  }
}
