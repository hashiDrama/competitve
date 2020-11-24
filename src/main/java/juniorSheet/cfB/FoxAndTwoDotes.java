/*
 * CFB round #290; link -> https://codeforces.com/contest/510/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class FoxAndTwoDotes {

  private static char[][] c;
  static int n, m;
  private static boolean[][] vis;
  private static boolean foundCycle;

  private static int[] di = new int[] {0, -1, 0, 1};
  private static int[] dj = new int[] {-1, 0, 1, 0};

  static boolean valid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  public static void dfs(int i, int j, int fi, int fj, char color) {
    if (!valid(i, j) || c[i][j] != color)
      return;
    if (vis[i][j]) {
      foundCycle = true;
      return;
    }
    vis[i][j] = true;
    for (int k = 0; k < 4; k++) {
      int ni = i + di[k];
      int nj = j + dj[k];
      if (ni == fi && nj == fj)
        continue;
      dfs(ni, nj, i, j, color);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    c = new char[n][m];
    String s;
    for (int i = 0; i < n; i++) {
      s = sc.next();
      c[i] = s.toCharArray();
    }
    vis = new boolean[n][m];
    foundCycle = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!vis[i][j])
          dfs(i, j, -1, -1, c[i][j]);
      }
    }
    if (foundCycle) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
    sc.close();
  }
}