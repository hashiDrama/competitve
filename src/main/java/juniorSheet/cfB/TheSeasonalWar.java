//uva - The Seasonal war - https://onlinejudge.org/external/3/352.pdf

package juniorSheet.cfB;

import java.io.PrintWriter;
import java.util.Scanner;

public class TheSeasonalWar {
  
  static PrintWriter pw = new PrintWriter(System.out);

  static int[][] pixel;
  static boolean[][] vis;
  static int n;

  static boolean valid(int i, int j) {
    return i >= 0 && j >= 0 && i < n && j < n;
  }

  static void dfs(int i, int j) {
    if (!valid(i, j) || vis[i][j] || pixel[i][j] != 1)
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
    int kase = 1;
    while (true) {
      n = sc.nextInt();
      pixel = new int[n][n];
      for (int i = 0; i < n; i++) {
        String line = sc.next();
        int jj = 0;
        for(char c : line.toCharArray()) {
          pixel[i][jj] = c - '0';
          jj++;
        }
      }
      vis = new boolean[n][n];
      int count = 0;
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
          if (pixel[i][j] == 1 && !vis[i][j]) {
            dfs(i, j);
            count++;
          }
        }
      System.out.println("Image number " + (kase++) + " contains " + count + " war eagles.");
      
    }
  }
}
