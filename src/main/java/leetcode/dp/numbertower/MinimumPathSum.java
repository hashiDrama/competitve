/*
 * Leetcode - Minimum Path Sum; link -> https://leetcode.com/problems/minimum-path-sum/
 */
package leetcode.dp.numbertower;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum {

  private static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] table = new int[m][n];
    for (int i = 0; i < m; i++)
      Arrays.fill(table[i], -1);
    table[0][0] = grid[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i < m - 1) {
          if (table[i + 1][j] == -1 || table[i + 1][j] > table[i][j] + grid[i + 1][j])
            table[i + 1][j] = table[i][j] + grid[i + 1][j];
        }
        if (j < n - 1) {
          if (table[i][j + 1] == -1 || table[i][j + 1] > table[i][j] + grid[i][j + 1])
            table[i][j + 1] = table[i][j] + grid[i][j + 1];
        }
      }
    }
    return table[m-1][n-1];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        grid[i][j] = sc.nextInt();
    System.out.println(minPathSum(grid));
    sc.close();
  }
}
