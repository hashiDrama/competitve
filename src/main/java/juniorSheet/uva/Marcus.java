package juniorSheet.uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Marcus {

  void read() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    StringBuilder ans = new StringBuilder();
    for (int t = 0; t < T; t++) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int y = 0;
      char[][] graph = new char[m][n];
      for (int i = 0; i < m; ++i) {
        String line = sc.next();
        int j = 0;
        for (char c : line.toCharArray()) {
          if (c == '@') {
            y = j;
          }
          graph[i][j++] = c;
        }
      }
      int i = m - 1, j = y;
      String str = "IEHOVA#";
      int[][] visited = new int[m][n];
      while (i >= 0 && i < m && j >= 0 && j < n) {
        if (graph[i][j] == '#') {
          break;
        }
        visited[i][j] = 1;
        if (i > 0 && str.contains("" + graph[i - 1][j]) && visited[i - 1][j] == 0) {
          i -= 1;
          ans.append("forth ");
          continue;
        }
        if (j > 0 && str.contains("" + graph[i][j - 1]) && visited[i][j - 1] == 0) {
          j -= 1;
          ans.append("left ");
          continue;
        }
        if (j < n - 1 && str.contains("" + graph[i][j + 1]) && visited[i][j + 1] == 0) {
          j += 1;
          ans.append("right ");
          continue;
        }
      }
      ans.append("\n");
    }
    System.out.println(ans);
    sc.close();
  }
}
