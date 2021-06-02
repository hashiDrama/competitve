/*
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2399
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PalindromicSubsequence {

  private static char[] c;
  private static int[][] mem;

  private static int lps(int lo, int hi) {
    if (mem[lo][hi] != -1)
      return mem[lo][hi];
    if (lo == hi)
      return mem[lo][hi] = 1;
    if (lo + 1 == hi) {
      if (c[lo] == c[hi])
        return mem[lo][hi] = 1;
      return mem[lo][hi] = 0;
    }

    int ans = 0;
    if (c[lo] != c[hi]) {
      int choice1 = lps(lo + 1, hi);
      int choice2 = lps(lo, hi - 1);
      ans = Math.max(choice1, choice2);
    } else
      ans = 1 + lps(lo + 1, hi - 1);

    return mem[lo][hi] = ans;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String s;
    while (true) {
      s = in.nextLine();
      if (s == null || s.trim().isEmpty())
        break;
      c = s.toCharArray();
      mem = new int[s.length()+1][s.length()+1];
      for(int i=0; i<s.length(); i++)
        Arrays.fill(mem[i], -1);
      System.out.println();
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
