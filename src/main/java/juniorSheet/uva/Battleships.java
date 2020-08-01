package juniorSheet.uva;

import java.util.Scanner;

public class Battleships {

  private static char[][] graph;
  private static int n;

  private static void dfs(int i, int j) {
    if (i < 0 || i >= n || j < 0 || j >= n) {
      return;
    }
    if (graph[i][j] == '.') {
      return;
    }
    graph[i][j] = '.';
    dfs(i - 1, j);
    dfs(i + 1, j);
    dfs(i, j - 1);
    dfs(i, j + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    StringBuilder response = new StringBuilder();
    for (int t = 0; t < T; t++) {
      n = sc.nextInt();
      graph = new char[n][n];
      for (int i = 0; i < n; i++) {
        int j = 0;
        for (char c : sc.next().toCharArray()) {
          graph[i][j++] = c;
        }
      }
      int res = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (graph[i][j] == 'x') {
            res++;
            dfs(i, j);
          }
        }
      }
      response.append("Case " + (t + 1) + ": " + res + "\n");
    }
    System.out.println(response);
    sc.close();
  }
}
