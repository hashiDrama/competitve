/*
 * https://practice.geeksforgeeks.org/problems/coin-change2448/1
 */
package gfg.sheet.dp;

import java.util.Scanner;

public class CoinChange {
 
  private static int countSumWays(int[] a, int sum) {
    int n = a.length;
    int[][] dp = new int[n + 1][sum + 1];
    for (int i = 0; i <= n; i++)
      dp[i][0] = 1;
    for (int j = 1; j <= sum; j++)
      dp[0][j] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        if (a[i - 1] <= j) {
          dp[i][j] += dp[i][j - a[i-1]];
        }
      }
    }
    return dp[n][sum];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[m];
    for (int i = 0; i < m; i++)
      a[i] = sc.nextInt();
    int ways = countSumWays(a, n);
    System.out.println(ways);
    sc.close();
  }
}
