/*
 * https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/
 */
package gfg.sheet.dp;

import java.util.Scanner;

public class MaxSumNo3Consecutive {

  /**
   * Finds the maximum sum subsequence of an array such that no two consecutive elements are
   * selected.
   */
  private static int solve(int[] a, int n) {
    int[] dp = new int[n + 1];
    dp[0] = a[0];
    dp[1] = a[0] + a[1];
    dp[2] = Math.max(dp[1], Math.max(a[1] + a[2], a[0] + a[2]));
    for (int i = 3; i < n; i++) {
      dp[i] = dp[i - 1]; // excluding ith elem
      if (i - 2 >= 0) // excluding (i-1t)h
        dp[i] = Math.max(dp[i], dp[i - 2] + a[i]);
      if (i - 3 >= 0)// excluding (i-2)th
        dp[i] = Math.max(dp[i], dp[i - 3] + a[i - 1] + a[i]);
    }
    return dp[n - 1];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n + 1];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    System.out.println(solve(a, n));
    sc.close();
  }
}
