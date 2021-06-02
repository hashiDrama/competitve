package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HistoryGrading {

  private static int s[], a[], n, dp[][];

  private static int lcs(int i, int j) {
    if (i == n || j == n)
      return 0;
    if (dp[i][j] != -1)
      return dp[i][j];

    int ans = 0;
    if (s[i] == a[j])
      ans = 1 + lcs(i + 1, j + 1);
    else {
      int choice1 = lcs(i + 1, j);
      int choice2 = lcs(i, j + 1);
      ans = Math.max(choice1, choice2);
    }
    dp[i][j] = ans;
    return ans;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line;
    String[] data = in.nextLine().split(" ");
    while (true) {
      n = Integer.parseInt(data[0]);
      data = in.nextLine().split(" ");

      s = new int[n];
      for (int i = 0; i < n; i++) {
        s[i] = Integer.parseInt(data[i]);
      }
      data = in.nextLine().split(" ");
      while (data.length > 1) {
        a = new int[n];
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
          Arrays.fill(dp[i], -1);
          a[i] = Integer.parseInt(data[i]);
        }
        System.out.println(lcs(0, 0));
        line = in.nextLine();
        if (line == null || line.isEmpty())
          return;
        data = line.split(" ");
      }
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
