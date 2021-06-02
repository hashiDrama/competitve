/*
 * https://codeforces.com/contest/131/problem/C
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheWorldIsAThreatre {

  public static void main(String[] args) {
    FastReader reader = new FastReader();

    long n = reader.nextLong();
    long m = reader.nextLong();
    long t = reader.nextLong();

    // Pascal's Triangle property to calculate combinations
    long[][] c = new long[61][61];
    for (int i = 0; i < 61; i++) {
      c[i][0] = c[i][i] = 1;
      for (int j = 1; j < i; j++)
        c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
    }

    long ans = 0;
    long remainingSlot;
    for (long i = 1; i <= t - 4; i++) {
      remainingSlot = t - i;
      ans += (c[(int) n][(int) remainingSlot] * c[(int) m][(int) i]);
    }
    System.out.println(ans);
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
