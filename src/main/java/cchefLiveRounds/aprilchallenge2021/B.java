package cchefLiveRounds.aprilchallenge2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class B {

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line = in.nextLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    double k1, k2, k3, v, chefTime;
    String[] data;
    double record = 9.58;
    while (t-- > 0) {
      k1 = in.nextDouble();
      k2 = in.nextDouble();
      k3 = in.nextDouble();
      v = in.nextDouble();
      chefTime = 100 / (k1 * k2 * k3 * v);
      DecimalFormat df = new DecimalFormat("#0.00");
      chefTime = Double.valueOf(df.format(chefTime));
      if (chefTime < record)
        System.out.println("YES");
      else
        System.out.println("NO");
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
