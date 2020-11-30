/*
 * CF-475/B; link -> https://codeforces.com/problemset/problem/475/B
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnectedCity {

  private static List<List<Integer>> adjList, adjList1;
  private static boolean[] vis;
  private static Stack<Integer> stack;
  private static int n, m;

  private static void dfs1(int u) {
    vis[u] = true;
    for (int i : adjList.get(u)) {
      if (!vis[i])
        dfs1(i);
    }
    stack.add(u);
  }

  private static void dfs2(int u) {
    vis[u] = true;
    //System.out.print(u + " ");
    for (int i : adjList1.get(u)) {
      if (!vis[i])
        dfs2(i);
    }
  }

  private static int kosaraju() {
    vis = new boolean[n * m];
    stack = new Stack<>();
    for (int i = 0; i < n * m; i++) {
      if (!vis[i])
        dfs1(i);
    }
    Arrays.fill(vis, false);
    int top, count = 0;
    while(!stack.isEmpty()) {
      top = stack.pop();
      if (!vis[top]) {
        count++;
        dfs2(top);
        //System.out.println();
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine();
    adjList = new ArrayList<>();
    adjList1 = new ArrayList<>();
    for (int i = 0; i < n * m; i++) {
      adjList.add(new ArrayList<>());
      adjList1.add(new ArrayList<>());
    }
    String[] roads = new String[2];
    roads[0] = sc.nextLine();
    roads[1] = sc.nextLine();
    int count = 0;

    // Creating adjacency list
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (roads[0].charAt(i) == '>') {
          if (j + 1 < m) {
            adjList.get(count).add(count + 1);
            adjList1.get(count + 1).add(count);
          }
        } else {
          if (j - 1 >= 0) {
            adjList.get(count).add(count - 1);
            adjList1.get(count - 1).add(count);
          }
        }
        if (roads[1].charAt(j) == 'v') {
          if (i + 1 < n) {
            adjList.get(count).add(count + m);
            adjList1.get(count + m).add(count);
          }
        } else {
          if (i - 1 >= 0) {
            adjList.get(count).add(count - m);
            adjList1.get(count - m).add(count);
          }
        }
        count++;
      }
    }
    int scc = kosaraju();
    if (scc > 1) {
      System.out.println("NO");
    } else {
      System.out.println("YES");
    }
    sc.close();
  }
}
