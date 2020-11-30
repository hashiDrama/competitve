/*
 * SPOJ-CATM The Cats and the Mouse; link -> https://www.spoj.com/problems/CATM/
 * Algo:
 * 1. run bfs for mouse and set the distances from mouse initial positions to all the positions of the grid
 * 2. repeat 1 for cats as well
 * 3. if mouse distance of any edge < cat distance then mouse can escape else not.
 */
package a2oj.dfsbfsdijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheCatsAndTheMouse {

  private static final int INF = Integer.MAX_VALUE;

  private static int n, m;
  private static boolean[][] vis;
  private static int[][] mdist, cdist;
  private static int[] di = new int[] {0, 0, -1, 1};
  private static int[] dj = new int[] {-1, 1, 0, 0};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  private static void bfs(int si, int sj, int[][] d) {
    for (int i = 0; i < n; i++)
      Arrays.fill(vis[i], false);
    Queue<Integer> q = new LinkedList<>();
    q.add(si);
    q.add(sj);
    d[si][sj] = 0;
    int i, j, ni, nj;
    while (!q.isEmpty()) {
      i = q.poll();
      j = q.poll();
      if (vis[i][j])
        continue;
      vis[i][j] = true;
      for (int t = 0; t < 4; t++) {
        ni = i + di[t];
        nj = j + dj[t];
        if (valid(ni, nj) && d[ni][nj] > d[i][j] + 1) {
          d[ni][nj] = d[i][j] + 1;
          q.add(ni);
          q.add(nj);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    int t = sc.nextInt();
    while (t-- > 0) {
      int mi, mj, c1i, c1j, c2i, c2j;
      mi = sc.nextInt()-1;
      mj = sc.nextInt()-1;
      c1i = sc.nextInt()-1;
      c1j = sc.nextInt()-1;
      c2i = sc.nextInt()-1;
      c2j = sc.nextInt()-1;
      vis = new boolean[n][m];
      mdist = new int[n][m];
      for (int i = 0; i < n; i++)
        Arrays.fill(mdist[i], INF);
      cdist = new int[n][m];
      for (int i = 0; i < n; i++)
        Arrays.fill(cdist[i], INF);
      bfs(mi, mj, mdist);
      bfs(c1i, c1j, cdist);
      bfs(c2i, c2j, cdist);
      boolean foundAns = false;
      String ans = "";
      for (int i = 0; i < n; i++) {
        if (mdist[i][0] < cdist[i][0] || mdist[i][m - 1] < cdist[i][m - 1]) {
          ans = "YES";
          foundAns = true;
          break;
        }
      }
      if (!foundAns) {
        for (int j = 0; j < m; j++) {
          if (mdist[0][j] < cdist[0][j] || mdist[n - 1][j] < cdist[n - 1][j]) {
            ans = "YES";
            foundAns = true;
            break;
          }
        }
      }
      if (!foundAns)
        ans = "NO";
      System.out.println(ans);
    }
    sc.close();
  }
}
