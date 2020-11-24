// uva-572 , link -> https://onlinejudge.org/external/5/572.pdf

package juniorSheet.cfB;

import java.util.Scanner;

public class OilDeposits {

  static boolean[][] vis;
  static char[][] grid;
  static int n, m;

  static boolean valid(int i, int j) {
    return i >= 0 && j >= 0 && i < n && j < m;
  }

  static void dfs(int i, int j) {
    if (!valid(i, j) || vis[i][j] || grid[i][j] != '@')
      return;
    vis[i][j] = true;
    dfs(i - 1, j - 1);
    dfs(i - 1, j);
    dfs(i - 1, j + 1);
    dfs(i, j - 1);
    dfs(i, j + 1);
    dfs(i + 1, j - 1);
    dfs(i + 1, j);
    dfs(i + 1, j + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      n = sc.nextInt();
      m = sc.nextInt();
      if (n == 0 && m == 0)
        break;
      grid = new char[n][m];
      int j;
      String line;
      for (int i = 0; i < n; i++) {
        line = sc.next();
        j = 0;
        for (char c : line.toCharArray())
          grid[i][j++] = c;
      }
      int count = 0;
      vis = new boolean[n][m];
      for (int i = 0; i < n; i++)
        for (j = 0; j < m; j++) {
          if (grid[i][j] == '@' && !vis[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      System.out.println(count);
    }
    sc.close();
  }
}
