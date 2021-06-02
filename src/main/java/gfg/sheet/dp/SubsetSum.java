/*
 * SubsetSum; link-> https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#
 */
package gfg.sheet.dp;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {

  private static boolean solve(int[] a) {
    int sum = Arrays.stream(a).sum();
    if (sum % 2 != 0)
      return false;
    sum /= 2;
    int n = a.length;
    boolean[][] dp = new boolean[n + 1][sum + 1];
    for (int i = 0; i <= n; i++)
      dp[i][0] = true;
    for (int j = 0; j <= sum; j++)
      dp[0][j] = false;
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if (a[i - 1] <= j)
          dp[i][j] = dp[i][j] || dp[i - 1][j - a[i - 1]];
      }
    }
    return dp[n][sum];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();

    boolean isSubsetSum = solve(a);
    System.out.println(isSubsetSum);
    sc.close();
  }
}
