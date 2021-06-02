/*
 * https://www.codechef.com/MARCH21C/problems/SPACEARR
 */
package cchefLiveRounds.marchChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Problem4 {

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    String line = fr.nextLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int n = fr.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++)
        a[i] = fr.nextInt();
      Arrays.sort(a);

      boolean second = false;
      int diff = 0;
      for (int i = 0; i < n; i++) {
        if (i + 1 >= a[i])
          diff += (i + 1 - a[i]);
        else {
          second = true;
          break;
        }
      }
      if (second)
        System.out.println("Second");
      else {
        if (diff % 2 == 1)
          System.out.println("First");
        else
          System.out.println("Second");
      }
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
