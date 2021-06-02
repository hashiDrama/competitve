/*
 * https://codeforces.com/contest/275/problem/C
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class KMultipleFreeSet {

  public static void main(String[] args) {
    FastReader in = new FastReader();
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextInt();
    Arrays.sort(a);
    Set<Integer> s = new HashSet<>();
    for (int i : a) {
      if (i % k != 0 || !s.contains(i / k))
        s.add(i);
    }
    System.out.println(s.size());
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
