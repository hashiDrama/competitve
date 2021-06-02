/*
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1680
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringToPalindrome {

  private static int mem[][];
  private static char[] c;

  private static int count(int lo, int hi) {
    if (mem[lo][hi] != -1)
      return mem[lo][hi];
    if (lo == hi)
      return mem[lo][hi] = 0;
    if (lo + 1 == hi) {
      if (c[lo] == c[hi])
        return mem[lo][hi] = 0;
      return mem[lo][hi] = 1;
    }

    int ans;
    if (c[lo] != c[hi]) {
      int choice1 = 1 + count(lo + 1, hi);
      int choice2 = 1 + count(lo, hi - 1);
      int choice3 = 1 + count(lo + 1, hi - 1);
      ans = Math.min(choice1, Math.min(choice2, choice3));
    } else
      ans = count(lo + 1, hi - 1);
    return mem[lo][hi] = ans;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    int t = in.nextInt();
    int kase = 1;
    while (t-- > 0) {
      String s = in.nextLine();
      mem = new int[s.length() + 1][s.length() + 1];
      for (int i = 0; i < s.length(); i++)
        Arrays.fill(mem[i], -1);
      c = s.toCharArray();
      System.out.println("Case " + kase + ": " + count(0, s.length() - 1));
      kase++;
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
