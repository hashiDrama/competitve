/*
 * https://codeforces.com/contest/378/problem/B
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Semifinals {

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    int n = reader.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    String[] line;
    for (int i = 0; i < n; i++) {
      line = reader.nextLine().split(" ");
      a[i] = Integer.parseInt(line[0]);
      b[i] = Integer.parseInt(line[1]);
    }
    boolean[] s1 = new boolean[n];
    boolean[] s2 = new boolean[n];
    for (int i = 0; i < n / 2; i++) {
      s1[i] = s2[i] = true;
    }
    int i = 0, j = 0, count = 0;
    while (i < n && j < n && count < n) {
      if (a[i] < b[j])
        s1[i++] = true;
      else
        s2[j++] = true;
      count++;
    }
    for (int k = 0; k < n; k++) {
      System.out.print(s1[k] ? 1 : 0);
    }
    System.out.println();
    for (int k = 0; k < n; k++) {
      System.out.print(s2[k] ? 1 : 0);
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
