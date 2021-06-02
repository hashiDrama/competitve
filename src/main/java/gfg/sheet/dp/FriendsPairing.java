/*
 * 
 */
package gfg.sheet.dp;

import java.util.Scanner;

public class FriendsPairing {

  private static final int mod = (int)1e9+7;
  
  // Memoization
  private static int solve(int n, int[] mem) {
    if (n <= 2)
      return mem[n] = n;
    return mem[n] = solve(n - 1, mem) + (n - 1) * solve(n - 2, mem);
  }

  // DP
  private static long solve1(int n) {
    long[] dp = new long[n + 1];
    for (int i = 0; i <= n; i++) {
      if (i <= 2)
        dp[i] = i;
      else
        dp[i] = (dp[i - 1] + ((i - 1) * dp[i - 2])%mod)%mod; // ith person can make pair with i-1 people hence
                                                 // (i-1) * dp[i-2]
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long ways = solve1(n);
    System.out.println(ways);
    sc.close();
  }
}
