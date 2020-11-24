/*
 * SPOJ - BITMAP; link -> https://www.spoj.com/problems/BITMAP/
 */
package a2oj.dfsbfsdijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bitmap {

  private static final int inf = 1000;

  private static char[][] grid;
  private static int n, m, min;
  private static boolean[][] vis;
  private static int[][] d;

  private static boolean valid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  //This causes TLE
  private static void dfs(int i, int j, int count) {
    if (!valid(i, j) || vis[i][j])
      return;
    if (grid[i][j] == '1') {
      min = Math.min(min, count);
      return;
    }
    vis[i][j] = true;
    count++;
    dfs(i, j - 1, count);
    dfs(i - 1, j, count);
    dfs(i, j + 1, count);
    dfs(i + 1, j, count);
    vis[i][j] = false;
  }

  private static void bfs(int i, int j) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    q.add(j);
    d[i][j] = 0;
    int x, y, dist;
    while (!q.isEmpty()) {
      x = q.poll();
      y = q.poll();
      dist = d[x][y] + 1;
      if (valid(x, y - 1) && dist < d[x][y - 1]) {
        q.add(x);
        q.add(y - 1);
        d[x][y - 1] = dist;
      }
      if (valid(x - 1, y) && dist < d[x - 1][y]) {
        q.add(x - 1);
        q.add(y);
        d[x - 1][y] = dist;
      }
      if (valid(x, y + 1) && dist < d[x][y + 1]) {
        q.add(x);
        q.add(y + 1);
        d[x][y + 1] = dist;
      }
      if (valid(x + 1, y) && dist < d[x + 1][y]) {
        q.add(x + 1);
        q.add(y);
        d[x + 1][y] = dist;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      n = sc.nextInt();
      m = sc.nextInt();
      sc.nextLine();
      grid = new char[n][m];
      vis = new boolean[n][m];
      d = new int[n][m];
      for (int i = 0; i < n; i++) {
        grid[i] = sc.nextLine().toCharArray();
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == '0')
            d[i][j] = inf;
          else
            d[i][j] = -1 * inf;
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == '1')
            bfs(i,j);
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m - 1; j++)
          System.out.print(d[i][j] + " ");
        System.out.println(d[i][m - 1]);
      }
    }
    sc.close();
  }
}
