/*
 * Leetcode- Minimum falling path sum; link->
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 */
package leetcode.dp.numbertower;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumFallingPathSum {

  private static int[][] dp;
  private static int n;

  public static int minFallingPathSum(int[][] arr) {
    n = arr.length;
    dp = new int[n][n];
    for (int i = 0; i < n; i++)
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      min = Math.min(min, helper(arr, 0, j));
    }
    return min;
  }

  private static int helper(int[][] arr, int r, int c) {
    if (r >= n)
      return 0;
    if (dp[r][c] != Integer.MAX_VALUE)
      return dp[r][c];
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      if(j != c) {
        min = Math.min(min, helper(arr, r + 1, j));
      }
    }
    dp[r][c] = arr[r][c] + min;
    return dp[r][c];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        arr[i][j] = sc.nextInt();
    }
    System.out.println(minFallingPathSum(arr));
    sc.close();
  }
}
