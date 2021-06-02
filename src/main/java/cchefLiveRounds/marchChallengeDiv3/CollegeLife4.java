/*
 * https://www.codechef.com/MARCH21C/problems/COLGLF4
 */
package cchefLiveRounds.marchChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CollegeLife4 {

  private static int N, E, H;
  private static long A, B, C;
  
  private static void solve() {
    FastReader fr = new FastReader();

    long best = Long.MAX_VALUE;
    // Iterating over number of chocolate cake
    for (int chocolateCakes = 0; chocolateCakes <= N; chocolateCakes++) {
      int e = E - chocolateCakes, h = H - chocolateCakes;
      if (e < 0 || h < 0)
        continue;
      // Maximum omelette and chocolate milkshake possible, if x chocolate cakes are ordered
      int omelettes = e / 2, chocolateMilkshakes = h / 3;
      if (chocolateCakes + omelettes + chocolateMilkshakes < N)// N orders not possible
        continue;
      int orders = N - chocolateCakes;
      long cost = chocolateCakes * C;
      int min;
      if (A <= B) {
        min = Math.min(orders, omelettes);
        cost += min * A;
        orders -= min;
        min = Math.min(orders, chocolateMilkshakes);
        cost += min * B;

        best = Math.min(best, cost);
      } else {
        min = Math.min(orders, chocolateMilkshakes);
        cost += min * B;
        orders -= min;
        min = Math.min(orders, omelettes);
        cost += min * A;

        best = Math.min(best, cost);
      }
    }
    if (best == Long.MAX_VALUE)
      best = -1;
    System.out.println(best);
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    String line = fr.nextLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      N = fr.nextInt();
      E = fr.nextInt();
      H = fr.nextInt();
      A = fr.nextLong();
      B = fr.nextLong();
      C = fr.nextLong();
      solve();
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
