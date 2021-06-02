/*
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=422
 */
package juniorSheet.cfB.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class WhatGoesUp {

  private static List<Integer> lis(List<Integer> a) {
    int n = a.size();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 1);

    int[] prev = new int[n + 1];
    Arrays.fill(prev, -1);
    int end = -1, max = -1;;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (a.get(j) < a.get(i) && dp[i] < dp[j] + 1) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
          if (dp[i] > max) {
            max = dp[i];
            end = i;
          }
        }
      }
    }
    List<Integer> ans = new ArrayList<>();
    while (end >= 0) {
      ans.add(a.get(end));
      end = prev[end];
    }
    Collections.reverse(ans);
    return ans;
  }

  public static void main(String[] args) {
    FastReader in = new FastReader();
    List<Integer> l = new ArrayList<>();
    String line;
    while (true) {
      line = in.nextLine();
      if (StringUtils.isEmpty(line))
        break;
      l.add(Integer.parseInt(line));
    }
    List<Integer> ans = lis(l);
    System.out.println(ans.size());
    System.out.println("-");
    ans.forEach(System.out::println);
  }

  private static class StringUtils {
    public static boolean isEmpty(String s) {
      return s == null || s.trim().isEmpty();
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
