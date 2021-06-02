/*
 * SPOJ-Bytelandian Gold Coins; link -> https://www.spoj.com/problems/COINS/
 */
package a2oj.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ByteLandianGoldCoins {

  private static long[] dp;

  private static long solve(int n) {
    if (n == 0)
      return 0;
    if (dp[n] != -1)
      return dp[n];
    dp[n] = Math.max(n, solve(n / 2) + solve(n / 3) + solve(n / 4));
    return dp[n];
  }

  private static long solve(int n, HashMap<Integer, Long> map) {
    if (n < 12)
      return n;
    if (map.containsKey(n))
      return map.get(n);
    long res = Math.max(n, solve(n / 2, map) + solve(n / 3, map) + solve(n / 4, map));
    map.put(n, res);
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      System.out.println(solve(n, new HashMap<Integer, Long>()));
    }
    sc.close();
  }
}
