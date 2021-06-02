/*
 * https://codeforces.com/contest/518/problem/B
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TanyaAndPostcard {

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    String s = reader.nextLine();
    String t = reader.nextLine();
    int[] ca = new int[128];
    for (char c : t.toCharArray()) {
      ca[c]++;
    }
    int i = 0, y = 0, w = 0;
    boolean[] set = new boolean[s.length()];
    for (char c : s.toCharArray()) {
      if (ca[c] != 0) {
        ca[c]--;
        y++;
        set[i] = true;
      }
      i++;
    }
    i = 0;
    int diff;
    for (char c : s.toCharArray()) {
      if (!set[i]) {
        if (c >= 'a' && c <= 'z') {
          diff = c - 'a';
          if (ca[diff + 'A'] != 0) {
            w++;
            ca[diff + 'A']--;
          }
        } else {
          diff = c - 'A';
          if (ca[diff + 'a'] != 0) {
            w++;
            ca[diff + 'a']--;
          }
        }
      }
      i++;
    }
    System.out.println(y + " " + w);
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
