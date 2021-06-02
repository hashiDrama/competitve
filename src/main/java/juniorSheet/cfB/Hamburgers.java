/*
 * http://codeforces.com/contest/371/problem/C
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hamburgers {

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    String recipe = fr.next();

    long n1 = 0, n2 = 0, n3 = 0;
    for (char c : recipe.toCharArray()) {
      if (c == 'B')
        n1++;
      if (c == 'S')
        n2++;
      if (c == 'C')
        n3++;
    }

    long nb = fr.nextLong();
    long ns = fr.nextLong();
    long nc = fr.nextLong();

    long pb = fr.nextLong();
    long ps = fr.nextLong();
    long pc = fr.nextLong();

    long r = fr.nextLong();

    long low = 0, high = (long) Math.pow(10, 15);
    while (low <= high) {
      long mid = low + (high - low) / 2;
      long cost = 0;
      if (n1 * mid > nb)
        cost += (n1 * mid - nb) * pb;
      if (n2 * mid > ns)
        cost += (n2 * mid - ns) * ps;
      if (n3 * mid > nc)
        cost += (n3 * mid - nc) * pc;
      if (cost <= r)
        low = mid + 1;
      else
        high = mid - 1;
    }
    System.out.println(high);
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
