package cchefLiveRounds.aprilchallenge2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line = in.nextLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    int n, k;
    while (t-- > 0) {
      n = in.nextInt();
      k = in.nextInt();
      String s = in.next();
      int count = 0;
      for (char c : s.toCharArray()) {
        if (c == '*')
          count++;
        else
          count = 0;
        if (count >= k)
          break;
      }
      if (count >= k)
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
