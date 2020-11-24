// uva-776, link -> https://onlinejudge.org/external/7/776.pdf

package juniorSheet.cfB;

import java.util.*;
import java.util.Scanner;

public class MonkeysInARegularForestBetter {

  static boolean[][] vis;
  static int n, m;
  static char[][] forest;
  static int[][] output;

  static boolean valid(int i, int j) {
    return i >= 0 && j >= 0 && i < n && j < m;
  }

  static void dfs(int i, int j, char curr, int val) {
    if (!valid(i, j) || vis[i][j])
      return;
    if (forest[i][j] != curr)
      return;
    vis[i][j] = true;
    output[i][j] = val;
    dfs(i - 1, j - 1, curr, val);
    dfs(i - 1, j, curr, val);
    dfs(i - 1, j + 1, curr, val);
    dfs(i, j - 1, curr, val);
    dfs(i, j + 1, curr, val);
    dfs(i + 1, j - 1, curr, val);
    dfs(i + 1, j, curr, val);
    dfs(i + 1, j + 1, curr, val);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {

      // read input
      List<String> data = new ArrayList<String>();
      String line = sc.nextLine();
      while (!line.equals("%")) {
        data.add(line);
        line = sc.nextLine();
        if (line.isEmpty())
          break;
      }

      // set arrays size
      n = data.size();
      m = data.get(0).replace(" ", "").length();

      // set forest
      forest = new char[n][m];
      int j;
      for (int i = 0; i < n; i++) {
        j = 0;
        for (char c : data.get(i).replace(" ", "").toCharArray()) {
          forest[i][j++] = c;
        }
      }

      // initialize visited and output array
      vis = new boolean[n][m];
      output = new int[n][m];

      // set family numbers
      int count = 1;

      // main loop
      for (int i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
          if (!vis[i][j]) {
            dfs(i, j, forest[i][j], count);
            count++;
          }
        }
      }

      // print output
      for (int i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
          System.out.print(output[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println("%");
      if (line.isEmpty())
        break;
    }
    sc.close();
  }
}
