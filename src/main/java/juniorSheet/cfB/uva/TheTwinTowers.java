/*
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1007
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheTwinTowers {

  private static int[] a, b;
  private static int[][] dp;
  private static int n1, n2, max;

  private static int lcs(int i, int j) {
    if (i == n1 || j == n2) {
      return 0;
    }
    if (dp[i][j] != -1)
      return dp[i][j];

    int ans = 0;
    if (a[i] == b[j])
      ans = 1 + lcs(i + 1, j + 1);
    else {
      int choice1 = lcs(i, j + 1);
      int choice2 = lcs(i + 1, j);
      ans = Math.max(choice1, choice2);
    }
    dp[i][j] = ans;
    return ans;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    int t = 1;
    while (true) {
      n1 = in.nextInt();
      n2 = in.nextInt();
      if (n1 == 0 && n2 == 0)
        break;

      a = new int[n1];
      b = new int[n2];
      for (int i = 0; i < n1; i++)
        a[i] = in.nextInt();
      for (int i = 0; i < n2; i++)
        b[i] = in.nextInt();
      max = 0;
      dp = new int[n1 + 1][n2 + 1];
      for (int i = 0; i <= n1; i++)
        Arrays.fill(dp[i], -1);
      int ans = lcs(0, 0);
      System.out.println("Twin Towers #" + t);
      System.out.println("Number of Tiles : " + ans);
      t++;
      System.out.println();
    }
  }

  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
