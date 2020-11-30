/*
 * SPOJ- Is it a tree; link -> https://www.spoj.com/problems/PT07Y/
 * 
 * Algo:-
 * During dfs, keep track of the current and previous node.
 * If, current node is already visited then there is a cycle, return from the function.
 * After dfs, if there is a node which is not visited, then there are disconnected components in the graph and hence these nodes were not visited.
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsItATree {

  private static List<List<Integer>> adjList;
  private static boolean[] vis;
  private static boolean ans;

  private static void dfs(int u, int prev) {
    if(vis[u]) {
      ans = false;
      return;
    }
    vis[u] = true;
    for (int v : adjList.get(u)) {
      if (v == prev) continue;
      dfs(v, u);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    adjList = new ArrayList<>();
    vis = new boolean[n];
    ans = true;
    for (int i = 0; i < n; i++)
      adjList.add(new ArrayList<>());
    int n1, n2;
    for (int i = 0; i < m; i++) {
      n1 = sc.nextInt() - 1;
      n2 = sc.nextInt() - 1;
      adjList.get(n1).add(n2);
      adjList.get(n2).add(n1);
    }
    dfs(0, 0);
    for(int i=0; i<n; i++) {
      if(!vis[i])
        ans = false;
    }
    System.out.println(ans ? "YES" : "NO");
    sc.close();
  }
}
