/*
 * uva - 10452; link ->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1393
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarcusHelp {

  private static char[][] grid;
  private static int m, n;
  private static boolean[][] vis;
  private static char[] safePlaces = new char[] {'I', 'E', 'H', 'O', 'V', 'A', '@', '#'};
  private static StringBuilder ans;

  private static boolean valid(int i, int j) {
    return i >= 0 && i < m && j >= 0 && j < n;
  }

  private static boolean safe(int i, int j) {
    for (char c : safePlaces)
      if (grid[i][j] == c)
        return true;
    return false;
  }

  private static List<String> cmds;
  private static void dfs(int i, int j) {
    if (!valid(i, j) || vis[i][j] || !safe(i, j)) {
      cmds.remove(cmds.size()-1);
      return; 
    }
    if (grid[i][j] == '#') {
      if(ans.length() == 0)
        cmds.forEach(cmd -> ans.append(cmd));
      return;
    }
    vis[i][j] = true;
    cmds.add(" left");
    dfs(i, j - 1);
    cmds.add(" right");
    dfs(i, j + 1);
    cmds.add(" forth");
    dfs(i - 1, j);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      m = sc.nextInt();
      n = sc.nextInt();
      sc.nextLine();
      grid = new char[m][n];
      String line;
      int si = -1, sj = -1;
      for (int i = 0; i < m; i++) {
        line = sc.nextLine();
        grid[i] = line.toCharArray();
        if (line.contains("@")) {
          sj = line.indexOf('@');
          si = i;
        }
      }
      vis = new boolean[m][n];
      cmds = new ArrayList<>();
      ans = new StringBuilder();
      dfs(si, sj);
      System.out.println(ans.toString().trim());
    }
    sc.close();
  }
}
