/*
 * https://www.codechef.com/JAN21C/problems/WIPL
 */
package cchefLiveRounds.janChallengeDiv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WatchingCPL {

  private static boolean[] vis;
  private static int k, n, gc;
  private static int[] a;

  private static void dfs(int u, int sum, int count, int found) {
    if (vis[u])
      return;
    if (sum >= k) {
      found++;
      if (found > 1) {
        gc = Math.min(gc, count);
      }
      sum = 0;
    }
    vis[u] = true;
    for (int i = 0; i < n; i++) {
      if (vis[i])
        continue;
      dfs(i, sum + a[i], count + 1, found);
    }
    vis[u] = false;
  }

  private static int solve(int[] a, int k) {
    Arrays.sort(a);
    int n = a.length;
    int sum, gc = Integer.MAX_VALUE, count;
    boolean[] vis;
    for (int i = n - 1; i >= 0; i--) {
      sum = a[i];
      count = 1;
      vis = new boolean[n];
      vis[i] = true;
      if (sum < k) {
        for (int j = n - 1; j >= 0; j--) {
          if (i == j || vis[j])
            continue;
          sum += a[j];
          count++;
          vis[j] = true;
          if (sum >= k)
            break;
        }
        if (sum < k)
          continue;
      }
      sum = 0;
      for (int j = n - 1; j >= 0; j--) {
        if (j == i || vis[j])
          continue;
        sum += a[j];
        count++;
        vis[j] = true;
        if (sum >= k)
          break;
      }
      if (sum < k)
        continue;
      gc = Math.min(gc, count);
    }
    if (gc == Integer.MAX_VALUE)
      gc = -1;
    return gc;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    String line = in.nextLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      n = in.nextInt();
      k = in.nextInt();
      a = new int[n];
      for (int i = 0; i < n; i++)
        a[i] = in.nextInt();
      // System.out.println(solve(a, k));
      gc = Integer.MAX_VALUE;
      vis = new boolean[n];
      for (int i = 0; i < n; i++) {
        dfs(i, a[i], 1, 0);
      }
      if (gc == Integer.MAX_VALUE)
        gc = -1;
      System.out.println(gc);

      // Arrays.sort(a);
      // int min = Integer.MAX_VALUE, count, sum, j, l;
      // for (int i = 0; i < n - 1; i++) {
      // count = 0;
      // sum = 0;
      // j = i;
      // for (; j < n; j++) {
      // sum += a[j];
      // if (sum >= k)
      // break;
      // }
      // if (sum < k)
      // continue;
      // count += j - i+1;
      // sum = 0;
      // l = j+1;
      // for (; l < n; l++) {
      // sum += a[l];
      // if (sum >= k)
      // break;
      // }
      // if (sum < k)
      // continue;
      // count += l - j;
      // min = Math.min(min, count);
      // }
      // if (min == Integer.MAX_VALUE)
      // min = -1;
      // System.out.println(min);
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
