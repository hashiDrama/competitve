/*
 * UVA-11624 Fire!; link ->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2671
 */
package a2oj.dfsbfsdijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Fire {

  private static final int INF = Integer.MAX_VALUE;
  private static int r, c;
  private static char[][] grid;
  private static boolean[][] vis;
  private static int[][] d1, d2;
  private static int[] di = new int[] {-1, 0, 1, 0};
  private static int[] dj = new int[] {0, 1, 0, -1};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < r && j >= 0 && j < c;
  }


  private static void bfs(int i, int j, int[][] d) {
    for (int t = 0; t < r; t++) {
      Arrays.fill(vis[t], false);
    }
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    q.add(j);
    d[i][j] = 0;
    int t, ni, nj;
    while (!q.isEmpty()) {
      i = q.poll();
      j = q.poll();
      if (vis[i][j])
        continue;
      vis[i][j] = true;

      for (t = 0; t < 4; t++) {
        ni = i + di[t];
        nj = j + dj[t];
        if (valid(ni, nj) && (grid[ni][nj] != 'F' && grid[ni][nj] != '#')) {
          q.add(ni);
          q.add(nj);
          if (d[ni][nj] > d[i][j] + 1) {
            d[ni][nj] = d[i][j] + 1;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      r = sc.nextInt();
      c = sc.nextInt();
      sc.nextLine();

      grid = new char[r][c];
      int ji = -1, jj = -1;
      for (int i = 0; i < r; i++) {
        grid[i] = sc.nextLine().toCharArray();
        if (ji == -1) {
          for (int j = 0; j < c; j++) {
            if (grid[i][j] == 'J') {
              ji = i;
              jj = j;
            }
          }
        }
      }

      vis = new boolean[r][c];
      d1 = new int[r][c];
      d2 = new int[r][c];
      for (int i = 0; i < r; i++) {
        Arrays.fill(d1[i], INF);
        Arrays.fill(d2[i], INF);
        Arrays.fill(vis[i], false);
      }
      bfs(ji, jj, d1);
      for(int i=0; i<r; i++) {
        for(int j=0; j<c; j++) {
          if(grid[i][j] == 'F')
            bfs(i, j, d2);
        }
      }
      boolean found = false;
      int idxi = -1, idxj = -1;
      for (int i = 0; i < r; i++) {
        if (d1[i][0] < d2[i][0]) {
          found = true;
          idxi = i;
          idxj = 0;
          break;
        }
        if (d1[i][c - 1] < d2[i][c - 1]) {
          found = true;
          idxi = i;
          idxj = c - 1;
        }
      }
      if (!found) {
        for (int j = 0; j < c; j++) {
          if (d1[0][j] < d2[0][j]) {
            found = true;
            idxi = 0;
            idxj = j;
            break;
          }
          if (d1[r - 1][j] < d2[r - 1][j]) {
            found = true;
            idxi = r - 1;
            idxj = j;
            break;
          }
        }
      }
      if (idxi == -1) {
        System.out.println("IMPOSSIBLE");
      } else {
        System.out.println(d1[idxi][idxj]+1);
      }
    }
  }
}
