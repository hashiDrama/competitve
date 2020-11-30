/*
 * SPOJ-KOZE SHEEP; link -> https://www.spoj.com/problems/KOZE/
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Koze {

  private static int n, m, countk, countv;
  private static char[][] grid;
  private static boolean[][] vis;
  private static int[] dx = new int[] {0, -1, 0, 1};
  private static int[] dy = new int[] {-1, 0, 1, 0};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] != '#';
  }

  private static void bfs(int i, int j) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    q.add(j);
    int x, y, nx, ny, k = 0, v = 0;
    boolean flag = false;
    while (!q.isEmpty()) {
      x = q.poll();
      y = q.poll();
      if (vis[x][y])
        continue;
      vis[x][y] = true;
      if (grid[x][y] == 'k')
        k++;
      if (grid[x][y] == 'v')
        v++;
      if (x == 0 || x == n - 1 || y == 0 || y == m - 1)
        flag = true;
      for (int t = 0; t < 4; t++) {
        nx = x + dx[t];
        ny = y + dy[t];
        if (valid(nx, ny)) {
          q.add(nx);
          q.add(ny);
        }
      }
    }
    if (flag) {
      countk += k;
      countv += v;
    } else {
      if (k > v)
        countk += k;
      else
        countv += v;
    }
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    n = fr.nextInt();
    m = fr.nextInt();
    grid = new char[n][m];
    vis = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      grid[i] = fr.nextLine().toCharArray();
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!vis[i][j] && grid[i][j] != '#') {
          bfs(i, j);
        }
      }
    }
    System.out.println(countk + " " + countv);
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
