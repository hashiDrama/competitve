/*
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1285
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OutOf5 {

  private static int[] a;
  private static boolean found, vis[];

  private static void backtrack(int len, int value, boolean isFirstTaken) {
    if (found)
      return;
    if (len == 5) {
      if (value == 23)
        found = true;
      return;
    }

    for (int i = 0; i < 5; i++) {
      if (vis[i])
        continue;

      // do
      vis[i] = true;
      if (!isFirstTaken)
        backtrack(len + 1, a[i], true);
      else {
        backtrack(len + 1, value + a[i], true);
        backtrack(len + 1, value - a[i], true);
        backtrack(len + 1, value * a[i], true);
      }
      // undo
      vis[i] = false;
    }
  }

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    String[] line;
    boolean notZeroNum;
    while (true) {
      line = reader.nextLine().split(" ");
      a = new int[5];
      notZeroNum = false;
      for (int i = 0; i < 5; i++) {
        a[i] = Integer.parseInt(line[i]);
        if (a[i] != 0)
          notZeroNum = true;
      }
      if (!notZeroNum)
        break;

      found = false;
      vis = new boolean[5];

      backtrack(0, 0, false);

      if (found)
        System.out.println("Possible");
      else
        System.out.println("Impossible");
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
