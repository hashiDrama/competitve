/*
 * SPOJ - ONEZERO; link -> https://www.spoj.com/problems/ONEZERO/
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class OneZero {

  private static int n;
  private static String ans;

  private static void bfs() {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair("1", 1));
    Pair top;
    while (!q.isEmpty()) {
      top = q.poll();
      if (top.second % n == 0) {
        ans = top.first;
        return;
      }
      top.second %= n;
      q.add(new Pair(top.first + "0", top.second * 10 + 0));
      q.add(new Pair(top.first + "1", top.second * 10 + 1));
    }
  }

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int k = fr.nextInt();
    while (k-- > 0) {
      n = fr.nextInt();
      ans = "";
      bfs();
      System.out.println(ans);
    }
  }

  private static class Pair implements Comparable<Pair> {
    String first;
    long second;

    public Pair(String first, long second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(Pair p) {
      return this.second < p.second ? -1 : this.second > p.second ? 1 : 0;
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
