/*
 * Kosaraju algorithm
 * 1. Run DFS on G and store the finished vertices in a stack so that the last finished vertex is on the top of stack.
 * 2. Create transpose of G(all edges reversed), GT.
 * 3. Run DFS on GT starting with the vertex on top of stack.
 * 4. When DFS ends, a component has been visited.
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Kosaraju {

  private static List<List<Integer>> adjList1, adjList2;
  private static int n;
  private static boolean[] vis;
  private static Stack<Integer> stack;

  private static void dfs1(int u) {
    vis[u] = true;
    for (int i : adjList1.get(u)) {
      if (!vis[i])
        dfs1(i);
    }
    stack.add(u);
  }

  private static void dfs2(int u) {
    vis[u] = true;
    System.out.print(u + " ");
    for (int i : adjList2.get(u)) {
      if (!vis[i])
        dfs2(i);
    }
  }
  
  private static void kosaraju() {
    vis = new boolean[n];
    stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (!vis[i])
        dfs1(i);
    }
    Arrays.fill(vis, false);
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        dfs2(i);
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    sc.nextLine();
    adjList1 = new ArrayList<>();
    adjList2 = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList1.add(new ArrayList<>());
      adjList2.add(new ArrayList<>());
    }
    int from, to;
    for (int i = 0; i < n; i++) {
      from = sc.nextInt() - 1;
      to = sc.nextInt() - 1;
      adjList1.get(from).add(to);
      adjList2.get(to).add(from);
    }
    kosaraju();
    sc.close();
  }
}
