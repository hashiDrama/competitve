/*
 * https://www.codechef.com/JAN21C/problems/DIVTHREE
 */
package cchefLiveRounds.janChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1 {

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line = in.nextLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int n = in.nextInt();
      int k = in.nextInt();
      int d = in.nextInt();
      int[] a = new int[n];
      int tp = 0;
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        tp += a[i];
      }
      int mc = tp / k;
      System.out.println(mc > d ? d : mc);
    }
  }

  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
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
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
