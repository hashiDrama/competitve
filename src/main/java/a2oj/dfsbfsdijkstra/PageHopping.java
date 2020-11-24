/*
 * uva-821 https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=762
 */
package a2oj.dfsbfsdijkstra;

import java.util.Scanner;

public class PageHopping {

  private static final int inf = 100000;
  private static final int SIZE = 105;
  private static int[][] a;
  private static boolean[] vis;

  private static void floydWarshall() {
    for (int k = 0; k < SIZE; k++)
      for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
          a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int ia, ib, t = 0;
    while (true) {
      t++;
      a = new int[SIZE][SIZE];
      for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
          a[i][j] = inf;

      vis = new boolean[SIZE];

      ia = sc.nextInt();
      ib = sc.nextInt();
      if (ia == 0 && ib == 0) {
        break;
      }

      while (true) {
        vis[ia - 1] = true;
        vis[ib - 1] = true;
        a[ia - 1][ib - 1] = 1;
        ia = sc.nextInt();
        ib = sc.nextInt();
        if (ia == 0 && ib == 0) {
          break;
        }
      }

      int sum = 0, count = 0;
      floydWarshall();
      for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++) {
          if (i == j)
            continue;
          if (vis[i] && vis[j]) {
            sum += a[i][j];
            count++;
          }
        }
      if (count != 0)
        System.out.printf("Case %d: average length between pages = %.3f clicks\n", t,
            (double) sum / count);
    }
    sc.close();
  }
}
