/*
 * https://www.spoj.com/problems/BITMAP/
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bitmap {

  private static final int MAX = Integer.MAX_VALUE;
  private static int[][] grid;
  private static int n, m;

  private static int[] dx = {0, 1, 0, -1};
  private static int[] dy = {1, 0, -1, 0};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  private static void multiSourceBFS() {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          q.add(i);
          q.add(j);
          grid[i][j] = 0;
        } else {
          grid[i][j] = MAX;
        }
      }
    int x, y, nx, ny;
    while (!q.isEmpty()) {
      x = q.poll();
      y = q.poll();
      for (int i = 0; i < 4; i++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (valid(nx, ny) && grid[nx][ny] > grid[x][y] + 1) {
          q.add(nx);
          q.add(ny);
          grid[nx][ny] = grid[x][y] + 1;
        }
      }
    }
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int t = fr.nextInt();
    while (t-- > 0) {
      n = fr.nextInt();
      m = fr.nextInt();
      grid = new int[n][m];
      String line;
      for (int i = 0; i < n; i++) {
        line = fr.nextLine();
        for (int j = 0; j < m; j++)
          grid[i][j] = line.charAt(j) - '0';
      }
      multiSourceBFS();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++)
          System.out.print(grid[i][j] + " ");
        System.out.println();
      }
    }
  }

  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
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

    double nextDouble() {
      return Double.parseDouble(next());
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
