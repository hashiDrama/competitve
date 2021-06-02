/*
 * https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&
 * problem=676
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pearls {

  public static void main(String[] args) {
    FastReader in = new FastReader();
    int t = in.nextInt();
    Task.solve(t, in);
  }

  private static class Task {

    public static void solve(int testCases, FastReader in) {
      while (testCases-- > 0) {
        int n = in.nextInt();
        int[] q = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
          q[i] = in.nextInt();
          p[i] = in.nextInt();
        }
        DP.q = q;
        DP.p = p;
        DP.n = n;
        DP.mem = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
          Arrays.fill(DP.mem[i], -1);
        int ans = DP.consecutiveKnapsack(0, 0);
        System.out.println(ans);
      }
    }
  }

  private static class DP {

    public static int q[], p[], n, mem[][];

    // Consecutive knapsack technique
    private static int consecutiveKnapsack(int i, int j) {
      if (j == n)
        return 0;
      if (mem[i][j] != -1)
        return mem[i][j];
      int choice1 = (sum(i, j) + 10) * p[j] + consecutiveKnapsack(i + 1, j + 1);
      int choice2 = Integer.MAX_VALUE;
      if (j + 1 < n)
        choice2 = consecutiveKnapsack(i, j + 1);
      return mem[i][j] = Math.min(choice1, choice2);
    }

    private static int sum(int i, int j) {
      int sum = 0;
      for (int k = i; k <= j; k++) {
        sum += q[k];
      }
      return sum;
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
