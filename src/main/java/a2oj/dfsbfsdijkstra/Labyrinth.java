/*
 * finding diameter of a tree 
 * SPOJ-Labyrinth; link -> https://www.spoj.com/problems/LABYR1/
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Labyrinth {

  private static final int negInf = Integer.MIN_VALUE;

  private static int r, c, max, maxr, maxc;
  private static char[][] grid;
  private static boolean[][] vis;

  private static int[] dx = new int[] {0, -1, 0, 1};
  private static int[] dy = new int[] {-1, 0, 1, 0};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < r && j >= 0 && j < c;
  }

  // finding dia of tree
  private static void dfs(int i, int j, int count) {
    vis[i][j] = true;
    if (count > max) {
      max = count;
      maxr = i;
      maxc = j;
    }
    int nx, ny;
    for (int t = 0; t < 4; t++) {
      nx = i + dx[t];
      ny = j + dy[t];
      if (valid(nx, ny) && !vis[nx][ny] && grid[nx][ny] != '#') {
        dfs(nx, ny, count + 1);
      }
    }
  }

  public static void main(String[] args) {
    FastReader sc = new FastReader();
    int t = sc.nextInt();
    while (t-- > 0) {
      c = sc.nextInt();
      r = sc.nextInt();
      grid = new char[r][c];
      for (int i = 0; i < r; i++)
        grid[i] = sc.nextLine().toCharArray();
      max = negInf;
      vis = new boolean[r][c];
      boolean foundHook = false;
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (!vis[i][j] && grid[i][j] != '#') {
            dfs(i, j, 0);
            foundHook = true;
            break;
          }
        }
        if (foundHook)
          break;
      }
      max = negInf;
      vis = new boolean[r][c];
      dfs(maxr, maxc, 0);
      System.out.println("Maximum rope length is " + max + ".");
    }
  }

  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
