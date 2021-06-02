/*
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=472
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Compromise {

  private static String s1[], s2[], longest;

  private static void lcs(int i, int j, String seq) {
    if (i == s1.length || j == s2.length) {
      return;
    }
    if (s1[i].equals(s2[j])) {
      if (!seq.isEmpty())
        seq += " " + s1[i];
      else
        seq = s1[i];
      if (longest.length() < seq.length())
        longest = seq;
      lcs(i + 1, j + 1, seq);
    } else {
      lcs(i + 1, j, seq);
      lcs(i, j + 1, seq);
    }
  }

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    String line, temp, data[];
    int count;
    while (true) {
      line = reader.nextLine();
      if (line == null || line.trim().isEmpty())
        break;
      temp = line;
      line = reader.next();
      while (!line.equals("#")) {
        temp += " " + line;
        line = reader.next();
      }
      s1 = temp.split(" ");
      temp = "";
      line = reader.next();
      while (!line.equals("#")) {
        temp += " " + line;
        line = reader.next();
      }
      temp = temp.substring(1, temp.length());
      s2 = temp.split(" ");

      longest = "";
      lcs(0, 0, "");
      System.out.println(longest);
      reader.nextLine();
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
