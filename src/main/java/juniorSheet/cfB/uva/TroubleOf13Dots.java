/*
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1760
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TroubleOf13Dots {

  private static int wt[], val[], n, W, dp[][], extraMoney = 200;

  // TOP DOWN with MEMOIZATION
  private static int knapsack1(int i, int w) {
    if (i == n)
      return 0;
    if (dp[i][w] != -1)
      return dp[i][w];

    int choice1 = knapsack1(i + 1, w);
    int choice2 = 0;
    if (w + wt[i] <= W + extraMoney)
      choice2 = knapsack1(i + 1, w + wt[i]) + val[i];
    return dp[i][w] = Math.max(choice1, choice2);
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line, data[];
    while (true) {
      line = in.nextLine();
      if (line == null || line.trim().isEmpty())
        break;
      data = line.split(" ");
      W = Integer.parseInt(data[0]);
      n = Integer.parseInt(data[1]);

      wt = new int[n];
      val = new int[n];
      dp = new int[n + 1][W + extraMoney + 1];
      for (int i = 0; i < n; i++) {
        wt[i] = in.nextInt();
        val[i] = in.nextInt();
        Arrays.fill(dp[i], -1);
      }
      int ans = knapsack1(0, 0);
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
