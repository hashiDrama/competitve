/*
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2853
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CreatingPalindrome {

  private static final int inf = Integer.MAX_VALUE;

  private static int a[], n, k, mem[][];

  // DP general range style
  private static int solve(int lo, int hi, int mv) {
    if (mv > k)
      return inf;
    if (lo >= hi)
      return mv;
    int ans;
    if (a[lo] == a[hi])
      ans = solve(lo + 1, hi - 1, mv);
    else
      ans = Math.min(solve(lo + 1, hi, mv + 1), solve(lo, hi - 1, mv + 1));
    return ans;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    int t = in.nextInt();
    int kase = 1;
    while (t-- > 0) {
      n = in.nextInt();
      k = in.nextInt();
      a = new int[n];
      for (int i = 0; i < n; i++)
        a[i] = in.nextInt();
      int count = solve(0, n - 1, 0);
      String ans = "Case " + kase + ": ";
      if (count == 0)
        ans += "Too easy";
      else if (count <= k)
        ans += count;
      else
        ans += "Too difficult";
      System.out.println(ans);
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
