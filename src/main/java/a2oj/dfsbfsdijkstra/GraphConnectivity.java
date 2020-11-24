/*
 * 1. Graph Connectivity - uva 459 - https://onlinejudge.org/external/4/459.pdf
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphConnectivity {

  private static List<List<Integer>> adjList;
  private static int n;
  private static boolean[] vis;

  private static void dfs(int u) {
    vis[u] = true;
    int v;
    for (int i = 0; i < adjList.get(u).size(); i++) {
      v = adjList.get(u).get(i);
      if (!vis[v]) {
        dfs(v);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    sc.nextLine();
    while (t-- > 0) {
      String firstLine = sc.nextLine();
      char largestNode = firstLine.charAt(0);
      n = (largestNode - 'A') + 1;
      adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
      }
      String line;
      while(sc.hasNextLine() && !(line = sc.nextLine()).isEmpty()) {
        char node1 = line.charAt(0);
        char node2 = line.charAt(1);
        if (!adjList.get(node1 - 'A').contains(node2 - 'A'))
          adjList.get(node1 - 'A').add(node2 - 'A');
        if (!adjList.get(node2 - 'A').contains(node1 - 'A'))
          adjList.get(node2 - 'A').add(node1 - 'A');
      }
      vis = new boolean[n];
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (!vis[i]) {
          dfs(i);
          count++;
        }
      }
      System.out.println(count);
      if(t != 0)
      System.out.println("");
    }
    sc.close();
  }
}
