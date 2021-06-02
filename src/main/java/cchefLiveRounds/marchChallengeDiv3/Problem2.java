/*
 * https://www.codechef.com/MARCH21C/problems/NOTIME
 */
package cchefLiveRounds.marchChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    String line = fr.nextLine();
    if (line == null)
      return;
    String[] data = line.split(" ");
    int n = Integer.parseInt(data[0]);
    int h = Integer.parseInt(data[1]);
    int x = Integer.parseInt(data[2]);

    int[] a = new int[n];
    data = fr.nextLine().split(" ");
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(data[i]);
      max = Math.max(max, a[i]);
    }

    if (max + x >= h)
      System.out.println("YES");
    else
      System.out.println("NO");
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
