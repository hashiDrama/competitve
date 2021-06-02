/*
 * https://www.geeksforgeeks.org/permutation-coefficient/
 */
package gfg.sheet.dp;

import java.util.Scanner;

public class PermutationCoefficient {

  /**
   * No of ways to arrange r elements out of n = (not choose nth element and arrange the r out of
   * n-1 elements) + (arrange r-1 elements out of n-1 elements and then choose a position for the
   * nth element out of r-1 chosen ones in r-1 ways)
   * 
   * TC: O(n*r); SC: O(n*r)
   */
  private static int permutation(int n, int r) {
    int[][] dp = new int[n + 1][r + 1];
    for (int i = 0; i <= n; i++)
      dp[i][0] = 1;
    for (int j = 0; j <= r; j++)
      dp[0][j] = 0;
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= r; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] * j;
      }
    }
    return dp[n][r];
  }

  /**
   * TC: O(n); SC: O(n)
   */
  private static int permutation1(int n, int r) {
    int[] fact = new int[n + 1];
    fact[0] = 1;
    for (int i = 1; i <= n; i++) {
      fact[i] = i * fact[i - 1];
    }
    return fact[n] / fact[n - r];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int r = sc.nextInt();
    System.out.println(permutation(n, r));
    System.out.println(permutation1(n, r));
    sc.close();
  }
}
