/*
 * https://codeforces.com/contest/313/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class IlyaAndQueries {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] c = sc.next().toCharArray();
    int m = sc.nextInt();
    int n = c.length;
    int l, r;
    int[] dp = new int[n];
    for (int i = 1; i < n; i++) {
      dp[i] = dp[i - 1];
      if (c[i] == c[i - 1])
        dp[i]++;
    }
    while (m-- > 0) {
      l = sc.nextInt();
      r = sc.nextInt();
      System.out.println(dp[r - 1] - dp[l - 1]);
    }
    sc.close();
  }
}
