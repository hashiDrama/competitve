/*
 * SPOJ-Distinct Subsequences; link -> https://www.spoj.com/problems/DSUBSEQ/
 */
package a2oj.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DistinctSubsequences {

  private static final int mod = (int)1e9 + 7;
  private static int dp(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    int[] last = new int[256];
    Arrays.fill(last, -1);
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i] = (2 * dp[i - 1])%mod;
      if (last[s.charAt(i - 1)] != -1)
        dp[i] = (dp[i] - dp[last[s.charAt(i - 1)] - 1] + mod)%mod;  //added mod to avoid mod of negative values
      last[s.charAt(i - 1)] = i;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- > 0) {
      String s = sc.nextLine();
      System.out.println(dp(s));
    }
    sc.close();
  }
}
