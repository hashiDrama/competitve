/*
 * https://www.codechef.com/MARCH21C/problems/GROUPS
 */
package cchefLiveRounds.marchChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1 {

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    String line = fr.nextLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      String s = fr.nextLine();
      int n = s.length(), groups = 0;
      for (int i = 0; i < n;) {
        if (s.charAt(i) == '1') {
          groups++;
          int j = i + 1;
          for (; j < n; j++)
            if (s.charAt(j) == '0')
              break;
          i = j;
        } else {
          i++;
        }
      }
      System.out.println(groups);
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
