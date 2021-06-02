/*
 * https://codeforces.com/contest/365/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class FIbonacciSegment {

  private static int dp(int n, int[] a) {
    if (n == 1 || n == 2)
      return n;
    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    int max = 0;
    for (int i = 2; i < n; i++) {
      if (a[i] == a[i - 1] + a[i - 2])
        dp[i] = dp[i - 1] + 1;
      else
        dp[i] = 2;
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  private static int solve(int n, int[] a) {
    int max = 0;
    if (n == 1 || n == 2)
      max = n;
    else {
      int i, j = 0;
      for (i = 2; i < n; i++) {
        if (a[i] != (a[i - 1] + a[i - 2])) {
          max = Math.max(max, i - j);
          j = i - 1;
        }
      }
      max = Math.max(max, i - j);
    }
    return max == 0 ? 2 : max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    System.out.println(dp(n, a));
    sc.close();
  }
}
