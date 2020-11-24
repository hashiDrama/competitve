/*
 * 
 * CF - Holidays link - https://codeforces.com/contest/699/problem/C
 * 
 * 0 - !G !C 
 * 1 - !G C 
 * 2 - G !C 
 * 3 - G C
 */

package juniorSheet.cfB;

import java.util.Scanner;
import static java.lang.Math.min;

public class Holidays {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    int[][] dp = new int[n + 1][3];
    //dp[][0] - rest
    //dp[][1] - contest
    //dp[][2] - gym
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[0][2] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i][0] = 1000;
      dp[i][1] = 1000;
      dp[i][2] = 1000;
      dp[i][0] = 1 + min(dp[i - 1][0], min(dp[i - 1][1], dp[i - 1][2]));
      if (a[i - 1] == 1 || a[i - 1] == 3) {
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]);
      }
      if (a[i - 1] == 2 || a[i - 1] == 3) {
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]);
      }
    }
    System.out.println(min(dp[n][0], min(dp[n][1], dp[n][2])));
    sc.close();
  }
}
