package juniorSheet.uva;

import java.util.Scanner;

public class TheSeasonalWar {

  private static int[][] graph;
  private static int[][] visited;
  static int n;

  private static void dfs(int x, int y) {
    if (x < 0 || x >= n || y < 0 || y >= n)
      return;
    if (graph[x][y] == 0 || visited[x][y] == 1)
      return;
    visited[x][y] = 1;
    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++)
        dfs(x + i, y + j);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t=0;
    while(true) {
      t++;
      n = Integer.parseInt(sc.nextLine());
      graph = new int[n][n];
      for (int i = 0; i < n; i++) {
        String line = sc.nextLine();
        int j = 0;
        for (char c : line.toCharArray()) {
          graph[i][j++] = Character.getNumericValue(c);
        }
      }
      visited = new int[n][n];
      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (graph[i][j] == 1 && visited[i][j] == 0) {
            dfs(i, j);
            count++;
          }
        }
      }
      System.out.println("Image number " + t + " contains " + count + " war eagles.");
    }
  }
}
