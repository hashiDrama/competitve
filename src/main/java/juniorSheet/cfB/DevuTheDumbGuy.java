/*
 * https://codeforces.com/contest/439/problem/B
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DevuTheDumbGuy {

  public static void main(String[] args) {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    long x = fs.nextInt();
    Integer[] c = fs.nextArray(n);
    Arrays.sort(c);
    long minTime = 0;
    for (int i = 0; i < n; i++) {
      minTime += c[i] * x;
      if(x>1)
         x--;
    }
    System.out.println(minTime);
  }

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
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
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

    Integer[] nextArray(int n) {
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
        arr[i] = nextInt();
      }
      return arr;
    }
  }
}
