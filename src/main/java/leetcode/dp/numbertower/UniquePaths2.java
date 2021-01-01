/*
 * Leetcode - Unique Paths 2; link -> https://leetcode.com/problems/unique-paths-ii/
 */
package leetcode.dp.numbertower;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths2 {

  private static int[][] mem;
  private static int m, n;

  public static int uniquePathsWithObstacles(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    mem = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++)
      Arrays.fill(mem[i], -1);
    return solve(m, n, grid);
  }

  private static int solve(int i, int j, int[][] grid) {
    if (i == 0 || j == 0)
      return 0;
    if (i < m && j < n && grid[i][j] == 1)
      return mem[i][j] = 0;
    if (mem[i][j] != -1)
      return mem[i][j];
    if (i == 1 || j == 1)
      return mem[i][j] = 1;
    return mem[i][j] = solve(i - 1, j, grid) + solve(i, j - 1, grid);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] grid = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        grid[i][j] = sc.nextInt();
    int ans = uniquePathsWithObstacles(grid);
    System.out.println(ans);
    sc.close();
  }
}
