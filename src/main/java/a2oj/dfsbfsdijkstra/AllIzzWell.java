/*
 * SPOJ-ALL IZZ WELL; link -> https://www.spoj.com/problems/ALLIZWEL/
 */
package a2oj.dfsbfsdijkstra;

import java.util.Scanner;

public class AllIzzWell {

  private static char[][] grid;
  private static int r, c;
  private static boolean vis[][], ans;

  private static int[] di = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
  private static int[] dj = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

  private static char[] ch = new char[] {'A', 'L', 'L', 'I', 'Z', 'Z', 'W', 'E', 'L', 'L'};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < r && j >= 0 && j < c;
  }

  private static void dfs(int i, int j, int idx) {
    if (!valid(i, j) || vis[i][j])
      return;
    if (idx == 9) {
      ans = true;
      return;
    }
    vis[i][j] = true;
    if (ch[idx] == grid[i][j]) {
      idx++;
      for (int t = 0; t < 8 && !ans; t++)
        dfs(i + di[t], j + dj[t], idx);
    }
    vis[i][j] = false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      r = sc.nextInt();
      c = sc.nextInt();
      sc.nextLine();
      grid = new char[r][c];
      for (int i = 0; i < r; i++)
        grid[i] = sc.nextLine().toCharArray();
      vis = new boolean[r][c];
      ans = false;
      for (int i = 0; i < r; i++) {
        if (ans)
          break;
        for (int j = 0; j < c; j++) {
          if (grid[i][j] == 'A') {
            dfs(i, j, 0);
            if (ans)
              break;
          }
        }
      }
      if (ans)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
    sc.close();
  }
}
