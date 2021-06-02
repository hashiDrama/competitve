/*
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&
 * problem=1133
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Vacation {

  private static char[] a, b;
  private static int n, m;
  private static int[][] mem;

  private static int lcs(int i, int j) {
    if (i >= n || j >= m)
      return 0;
    if (mem[i][j] != -1)
      return mem[i][j];
    int ans = 0;
    if (a[i] == b[j])
      ans = 1 + lcs(i + 1, j + 1);
    else
      ans = Math.max(lcs(i + 1, j), lcs(i, j + 1));
    mem[i][j] = ans;
    return ans;
  }

  private static int lcsBottomUp() {
    int[][] lcs = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++)
      lcs[i][0] = 0; // If 2nd string is empty then max lcs length will be 0
    for (int j = 0; j <= m; j++)
      lcs[0][j] = 0; // If 1st string is empty then max lcs length will be 0

    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= m; j++) {
        if (a[i - 1] == b[j - 1])
          lcs[i][j] = 1 + lcs[i - 1][j - 1];
        else
          lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
      }
    return lcs[n][m];
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line;
    int kase = 1;
    while (true) {
      line = in.nextLine();
      if ("#".equals(line))
        break;
      a = line.toCharArray();
      b = in.nextLine().toCharArray();
      n = a.length;
      m = b.length;
      mem = new int[n + 1][m + 1];
      for (int i = 0; i <= n; i++)
        Arrays.fill(mem[i], -1);
      // int ans = lcs(0, 0);
      int ans = lcsBottomUp();
      System.out.println("Case #" + kase + ": you can visit at most " + ans + " cities.");
      kase++;
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
