/*
 * https://codeforces.com/problemset/problem/500/A
 */
package cfproblemset.dfsandsimilar;

import java.util.Scanner;

public class NewYearResolution {

  private static int[] adjList;
  private static boolean[] vis;
  private static int t;
  private static boolean ans;

  private static void dfs(int u) {
    vis[u] = true;
    int v = adjList[u];
    if (v == t-1)
      ans = true;
    else if (!vis[v])
      dfs(v);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    t = sc.nextInt();
    adjList = new int[n];
    int temp;
    for (int i = 0; i < n-1; i++) {
      temp = sc.nextInt();
      adjList[i] = i + temp;
    }
    vis = new boolean[n];
    ans = false;
    dfs(0);
    if (ans)
      System.out.println("YES");
    else
      System.out.println("NO");
    sc.close();
  }
}
