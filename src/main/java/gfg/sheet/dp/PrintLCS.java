/*
 * https://practice.geeksforgeeks.org/problems/lcs-of-three-strings/0
 */
package gfg.sheet.dp;

import java.util.Scanner;

public class PrintLCS {

  public static void main(String[] args) throws Exception {
    // code
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      String x = sc.next();
      String y = sc.next();
      String z = sc.next();
      // String lcs1 = lcs(x, y);
      // int lcs2 = lcs(lcs1, z, lcs1.length(), k);
      // System.out.println(lcs2);
      System.out.println(lcs(x, y, z, n, m, k));
    }
  }

  private static int lcs(String s1, String s2, int n, int m) {
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else {
          if (s1.charAt(i - 1) == s2.charAt(j - 1))
            dp[i][j] = 1 + dp[i - 1][j - 1];
          else
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][m];
  }

  private static int lcs(String s1, String s2, String s3, int n1, int n2, int n3) {
    int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
    for (int i = 0; i <= n1; i++)
      for (int j = 0; j <= n2; j++)
        for (int k = 0; k <= n3; k++) {
          if (i == 0 || j == 0 || k == 0)
            dp[i][j][k] = 0;
          else {
            if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1))
              dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
            else
              dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
          }
        }
    return dp[n1][n2][n3];
  }

  private static String lcs(String s1, String s2) {
    int n1 = s1.length();
    int n2 = s2.length();
    int[][] dp = new int[n1 + 1][n2 + 1];
    for (int i = 0; i <= n1; i++) {
      for (int j = 0; j <= n2; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else {
          if (s1.charAt(i - 1) == s2.charAt(j - 1))
            dp[i][j] = 1 + dp[i - 1][j - 1];
          else
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int i = n1, j = n2;
    StringBuilder sb = new StringBuilder();
    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        sb.append(s1.charAt(i - 1));
        i--;
        j--;
      } else {
        if (dp[i - 1][j] > dp[i][j - 1])
          i--;
        else
          j--;
      }
    }
    return sb.reverse().toString();
  }

}
