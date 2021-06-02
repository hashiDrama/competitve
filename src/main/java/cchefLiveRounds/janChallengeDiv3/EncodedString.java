/*
 * https://www.codechef.com/JAN21C/problems/DECODEIT
 */
package cchefLiveRounds.janChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EncodedString {

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line = in.nextLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int n = in.nextInt();
      String str = in.nextLine();
      StringBuilder ans = new StringBuilder();
      int i;
      for (int j = 0; j <= n - 4; j += 4) {
        i = 0;
        i += str.charAt(j) == '1' ? 8 : 0;
        i += str.charAt(j + 1) == '1' ? 4 : 0;
        i += str.charAt(j + 2) == '1' ? 2 : 0;
        i += str.charAt(j + 3) == '1' ? 1 : 0;
        ans.append((char)('a' + i));
      }
      System.out.println(ans.toString());
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
