/*
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=7&page=show_problem&
 * problem=503
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DividingCoins {

  public static void main(String[] args) {
    FastReader in = new FastReader();
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++)
        a[i] = in.nextInt();
      Arrays.sort(a);
      int l = 1, r = n - 2, sl = a[0], sr = a[n - 1];
      while (l <= r) {
        if (sl < sr) {
          sl += a[l];
          l++;
        } else {
          sr += a[r];
          r--;
        }
      }
      System.out.println(Math.abs(sl - sr));
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
