/*
 * https://arena.topcoder.com/index.html#/u/coding/18535/16827/1
 */
package topcoder.rookiesrm3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SoFarAway {

  private static char[][] grid;
  private static int m, n;

  private static final int[] dx = new int[] {-1, 0, 1, 0};
  private static final int[] dy = new int[] {0, 1, 0, -1};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] != 'X';
  }

  private static int bfs(int si, int sj, int di, int dj) {
    int dist = 0;
    Queue<Integer> q = new LinkedList<>();
    boolean[][] vis = new boolean[m][n];
    q.add(si);
    q.add(sj);
    int i, j, ni, nj;
    while (!q.isEmpty()) {
      i = q.poll();
      j = q.poll();
      if (i == di && j == dj)
        return dist;
      if (vis[i][j])
        continue;
      vis[i][j] = true;
      dist++;
      for (int k = 0; k < 4; k++) {
        ni = i + dx[k];
        nj = j + dy[k];
        if (valid(ni, nj)) {
          q.add(ni);
          q.add(nj);
        }
      }
    }
    return -1;
  }

  public int distance(String[] plan) {
    int si = -1, sj = -1, di = -1, dj = -1;
    int i = 0;
    m = plan.length;
    n = plan[0].length();
    grid = new char[m][n];

    for (String s : plan) {
      grid[i] = s.toCharArray();
      if (s.contains("S")) {
        si = i;
        sj = s.indexOf('S');
      }
      if (s.contains("D")) {
        di = i;
        dj = s.indexOf('D');
      }
      i++;
    }
    return bfs(si, sj, di, dj);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    m = sc.nextInt();
    n = sc.nextInt();
    String[] plan = new String[m];
    for (int i = 0; i < m; i++) {
      plan[i] = sc.next();
    }
    System.out.println(new SoFarAway().distance(plan));
    sc.close();
  }
}
