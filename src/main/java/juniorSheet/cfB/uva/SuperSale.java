/*
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1071
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SuperSale {

  private static final int MAX = 1005;
  private static int[] wt, pr;
  private static int n, cap;
  private static int[][] dp;

  private static int knapsack(int i, int w) {
    if (i == n)
      return 0;
    if (dp[i][w] != -1)
      return dp[i][w];
    int choice1 = knapsack(i + 1, w);
    int choice2 = 0;
    if (w + wt[i] <= cap)
      choice2 = pr[i] + knapsack(i + 1, w + wt[i]);
    return dp[i][w] = Math.max(choice1, choice2);
  }

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    int t = reader.nextInt();
    while (t-- > 0) {
      n = reader.nextInt();
      wt = new int[n];
      pr = new int[n];
      for (int i = 0; i < n; i++) {
        pr[i] = reader.nextInt();
        wt[i] = reader.nextInt();
      }
      int people = reader.nextInt();
      int ans = 0;
      while (people-- > 0) {
        dp = new int[n+1][31];
        for (int i = 0; i < n+1; i++)
          Arrays.fill(dp[i], -1);
        cap = reader.nextInt();
        ans += knapsack(0, 0);
      }
      System.out.println(ans);
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
