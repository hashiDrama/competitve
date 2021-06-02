/*
 * https://www.codechef.com/problems/GCDMOD
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ModularGCD {

  private static final int mod = (int) 1e9 + 7;

  // Modular exponentiation in O(log(b))
  private static long powMod(long a, long b, long m) {
    long res = 1;
    a %= m;
    if (a == 0)
      return 0;
    while (b > 0) {
      if ((b & 1) != 0) // b is odd
        res = (res * a) % m;
      b = b >> 1; // b /= 2
      a = (a * a) % m;
    }
    return res;
  }

  private static long gcd(long a, long b) {
    long r;
    while (b > 0) {
      r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    String line = reader.nextLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      long a = reader.nextLong();
      long b = reader.nextLong();
      long n = reader.nextLong();

      long a1 = powMod(a, n, a-b);
      long b1 = powMod(b, n, a-b);

      long ans = (a1 + b1) % (a-b);

      ans = gcd(ans, Math.abs(a - b));
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
