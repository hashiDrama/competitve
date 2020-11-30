package cchefLiveRounds.novLunchtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GasolineIntroduction {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if(line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      line = br.readLine();
      int n = Integer.parseInt(line);
      int[] f = new int[n];
      line = br.readLine();
      String[] arr = line.split(" ");
      for (int i = 0; i < n; i++)
        f[i] = Integer.parseInt(arr[i]);
      int fuel = f[0], i;
      for (i = 1; i < n; i++) {
        if (fuel == 0)
          break;
        fuel--;
        fuel += f[i];
      }
      i--;
      fuel += i;
      System.out.println(fuel);
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
        } catch (Exception e) {
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
