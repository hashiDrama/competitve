/*
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=944
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingSticks {

  private static int L, a[], n, mem[][];

  //MCM approach
  private static int solve(int l, int r) {
    if (l + 1 == r)
      return 0;
    if (mem[l][r] != -1)
      return mem[l][r];
    int ans = Integer.MAX_VALUE;
    for (int i = l + 1; i < r; i++)
      ans = Math.min(ans, a[r] - a[l] + solve(l, i) + solve(i, r));

    return mem[l][r] = ans;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    while (true) {
      L = in.nextInt();
      if (L == 0)
        break;
      n = in.nextInt();
      a = new int[n + 2];
      a[0] = 0;
      for (int i = 1; i < n + 1; i++)
        a[i] = in.nextInt();
      a[n + 1] = L;
      mem = new int[n + 3][n + 3];
      for (int i = 0; i < n + 3; i++)
        Arrays.fill(mem[i], -1);
      int ans = solve(0, n + 1);
      System.out.println("The minimum cutting is " + ans + ".");
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
