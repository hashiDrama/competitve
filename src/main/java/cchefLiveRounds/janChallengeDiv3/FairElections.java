package cchefLiveRounds.janChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FairElections {

  private static int[] a, b;

  private static int solve(int i, int j, int va, int vb, int swaps) {
    if (i >= a.length || j < 0)
      return -1;
    va -= a[i];
    va += b[j];
    vb -= b[j];
    vb += a[i];
    swaps++;
    if (va > vb)
      return swaps;
    int temp = a[i];
    a[i] = b[j];
    b[j] = temp;
    return solve(i + 1, j - 1, va, vb, swaps);
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line = in.nextLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      a = new int[n];
      b = new int[m];
      int va = 0, vb = 0;
      for (int i = 0; i < n; i++) {
        a[i] = in.nextInt();
        va += a[i];
      }
      for (int i = 0; i < m; i++) {
        b[i] = in.nextInt();
        vb += b[i];
      }
      Arrays.sort(a);
      Arrays.sort(b);
      if (va > vb) {
        System.out.println(0);
        continue;
      }
      int ans = solve(0, m-1, va, vb, 0);
      System.out.println(ans);
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
