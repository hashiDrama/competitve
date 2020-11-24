/*
 * uva-10009; link ->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=950
 */
package a2oj.dfsbfsdijkstra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AllRoadLeadWhere {

  private static final int SIZE = 30;
  private static int[][] adj;
  private static int[] par;
  private static boolean[] vis;

  private static void bfs(int s, int e) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    while (!q.isEmpty()) {
      int c = q.poll();
      vis[c] = true;
      for (int i = 0; i < SIZE; i++) {
        if (adj[c][i] == 1 && !vis[i]) {
          q.add(i);
          par[i] = c;
          if (i == e)
            return;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- > 0) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      sc.nextLine();
      adj = new int[SIZE][SIZE];
      vis = new boolean[SIZE];
      par = new int[SIZE];
      String[] line;
      char c1, c2;
      for (int i = 0; i < n; i++) {
        line = sc.nextLine().split(" ");
        c1 = line[0].charAt(0);
        c2 = line[1].charAt(0);
        adj[c1 - 64][c2 - 64] = 1;
        adj[c2 - 64][c1 - 64] = 1;
      }
      for (int i = 0; i < q; i++) {
        line = sc.nextLine().split(" ");
        c1 = line[0].charAt(0);
        c2 = line[1].charAt(0);
        bfs(c2 - 64, c1 - 64);
        System.out.print(c1);
        int s = c1 - 64;
        int e = c2 - 64;
        while (s != e) {
          System.out.print(" " + (char)(par[s] + 64));
        }
        System.out.println();
      }
      if (t > 0)
        System.out.println();
    }
    sc.close();
  }
}
