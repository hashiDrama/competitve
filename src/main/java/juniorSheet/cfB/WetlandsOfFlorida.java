// uva 469 - link -> https://onlinejudge.org/external/4/469.pdf

package juniorSheet.cfB;

import java.util.Scanner;

public class WetlandsOfFlorida {

  static int n, m = 0, MAX = 100, count;
  static char[][] grid;
  static boolean[][] vis;

  static boolean valid(int i, int j) {
    return i >= 0 && j >= 0 && i < n && j < m;
  }

  static void dfs(int i, int j) {
    if (!valid(i, j) || vis[i][j] || grid[i][j] != 'W')
      return;
    vis[i][j] = true;
    count++;
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
    int t = sc.nextInt();
    sc.nextLine();
    sc.nextLine();// remove dummy line
    while (t-- > 0) {
      grid = new char[MAX][MAX];
      String line = "";
      int i = 0, j;

      while (true) {
        line = sc.nextLine();
        if (line.indexOf('W') < 0 && line.indexOf('L') < 0)
          break;
        j = 0;
        for (char c : line.toCharArray())
          grid[i][j++] = c;
        i++;
        if (m == 0)
          m = j;
      }
      n = i;
      while (!line.isEmpty()) {
        String[] values = line.split(" ");
        int r = Integer.parseInt(values[0]) - 1;
        int c = Integer.parseInt(values[1]) - 1;
        count = 0;
        vis = new boolean[n][m];
        dfs(r, c);
        System.out.println(count);
        line = sc.nextLine();
      }
      sc.nextLine();
      System.out.println(); // Separating two test cases output by a blank line
    }
    sc.close();
  }
}


class ScannerT {

}
