/*
 * Codeforces 254-A, DZE Loves Chessboard link -> https://codeforces.com/problemset/problem/445/A
 */
package a2oj.dfsbfsdijkstra;

import java.util.Scanner;

public class DZYLovesChessboard {

  private static char[][] grid;
  private static int n, m;
  private static char[] c = new char[] {'B', 'W'};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  private static void dfs(int i, int j, int t) {
    if (!valid(i, j) || grid[i][j] != '.')
      return;
    grid[i][j] = c[t];
    t = 1 - t;
    dfs(i, j - 1, t);
    dfs(i - 1, j, t);
    dfs(i, j + 1, t);
    dfs(i + 1, j, t);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine();
    grid = new char[n][m];
    for (int i = 0; i < n; i++) {
      grid[i] = sc.nextLine().toCharArray();
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(grid[i][j] == '.')
           dfs(i, j, 0);
      }  
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++)
        System.out.print(grid[i][j]);
      System.out.println();
    }
    sc.close();
  }
}
