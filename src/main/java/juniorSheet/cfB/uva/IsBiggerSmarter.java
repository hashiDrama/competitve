/*
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=1072
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IsBiggerSmarter {

  private static List<Elephant> elephants, maxL;
  private static int n;

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    String line, data[];
    elephants = new ArrayList<>();
    n = 0;
    maxL = new ArrayList<>();
    while (true) {
      line = reader.nextLine();
      if (line == null || line.trim().isEmpty())
        break;
      data = line.split(" ");
      Elephant e = new Elephant();
      e.w = Integer.parseInt(data[0]);
      e.iq = Integer.parseInt(data[1]);
      e.idx = n;
      elephants.add(e);
      n++;
    }

    // Sort on the basis of increasing w and decreasing iq
    elephants.sort((Elephant e1, Elephant e2) -> {
      if (e1.w == e2.w)
        return Integer.compare(e1.iq, e2.iq);
      return Integer.compare(e2.w, e1.w);
    });

    int maxs = 0;
    int[] dp = new int[n];
    int[] nxt = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      nxt[i] = -1;
    }

    int v = -1;

    //LIS
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (elephants.get(j).w < elephants.get(i).w && elephants.get(j).iq > elephants.get(i).iq
            && dp[j] < dp[i] + 1) {
          dp[j] = dp[i] + 1;
          nxt[j] = i;
          if (dp[j] > maxs) {
            maxs = dp[j];
            v = j;
          }
        }
      }
    }
    System.out.println(maxs);
    while (v >= 0) {
      System.out.println(elephants.get(v).idx + 1);
      v = nxt[v];
    }

    maxL.forEach(e -> System.out.println(e.w + " " + e.iq));
  }

  private static class Elephant {
    int w;
    int iq;
    int idx;
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
