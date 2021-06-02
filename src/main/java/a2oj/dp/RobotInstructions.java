/*
 * UVA-12503; link ->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3947
 */
package a2oj.dp;

import java.util.Scanner;

public class RobotInstructions {

  private static int solveUsingDp(int[] a) {
    int n = a.length;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      if (a[i - 1] == 0)
        dp[i] = dp[i - 1] - 1;
      else
        dp[i] = dp[i - 1] + 1;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      String line;
      sc.nextLine();
      for (int i = 0; i < n; i++) {
        line = sc.nextLine().trim();
        if (line.equals("LEFT"))
          a[i] = 0;
        else if (line.equals("RIGHT"))
          a[i] = 1;
        else {
          int idx = Integer.parseInt(line.split(" ")[2]);
          a[i] = a[idx - 1];
        }
      }
      System.out.println(solveUsingDp(a));
    }
    sc.close();
  }
}
