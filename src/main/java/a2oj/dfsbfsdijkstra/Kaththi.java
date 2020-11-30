/*
 * SPOJ - KATHTHI link -> https://www.spoj.com/problems/KATHTHI/
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kaththi {

  private static final int inf = 5000;
  private static int r, c;
  private static char[][] grid;
  private static int[] dx = new int[] {0, 1, 0, -1};
  private static int[] dy = new int[] {1, 0, -1, 0};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < r && j >= 0 && j < c;
  }

  private static int bfs01() {
    int[][] d = new int[r][c];
    for (int i = 0; i < r; i++)
      Arrays.fill(d[i], inf);
    Deque<Integer> q = new LinkedList<>();
    q.addFirst(0);
    q.addFirst(0);
    d[0][0] = 0;
    int x, y, nx, ny;
    while (!q.isEmpty()) {
      x = q.pollFirst();
      y = q.pollFirst();
      if (x == r - 1 && y == c - 1)
        break;
      for (int i = 0; i < 4; i++) {
        nx = x + dx[i];
        ny = y + dy[i];
        if (valid(nx, ny)) {
          if (grid[x][y] == grid[nx][ny] && d[nx][ny] > d[x][y]) {
            d[nx][ny] = d[x][y];
            q.addFirst(ny);
            q.addFirst(nx);
          } else if (d[nx][ny] > d[x][y] + 1) {
            d[nx][ny] = d[x][y] + 1;
            q.addLast(nx);
            q.addLast(ny);
          }
        }
      }
    }
    return d[r - 1][c - 1];
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int t = fr.nextInt();
    while (t-- > 0) {
      r = fr.nextInt();
      c = fr.nextInt();
      grid = new char[r][c];
      for (int i = 0; i < r; i++)
        grid[i] = fr.nextLine().toCharArray();
      System.out.println(bfs01());
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
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
