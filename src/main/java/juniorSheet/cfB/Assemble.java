/*
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3276
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Assemble {

  private static Map<String, List<Component>> map;
  private static List<String> items;
  private static long maxQ, budget;

  private static void assemble(int i, long amt, long q) {
    if (i >= items.size()) { // base case
      if (amt <= budget) {
        maxQ = Math.max(maxQ, q);
      }
      return;
    }
    // iteration
    for (Component c : map.get(items.get(i))) {
      if (amt + c.price <= budget) {
        assemble(i + 1, amt + c.price, Math.min(q, c.quality));
      }
    }
  }

  public static void main(String[] args) {
    FastReader reader = new FastReader();
    int t = reader.nextInt();
    while (t-- > 0) {
      int n = reader.nextInt();
      budget = reader.nextLong();

      map = new HashMap<>();
      items = new ArrayList<>();
      String[] line;
      for (int i = 0; i < n; i++) {
        line = reader.nextLine().split(" ");
        map.putIfAbsent(line[0], new ArrayList<>());
        Component c = new Component();
        c.name = line[1];
        c.price = Long.parseLong(line[2]);
        c.quality = Long.parseLong(line[3]);
        map.get(line[0]).add(c);
      }
      items = new ArrayList(map.keySet());
      maxQ = Long.MIN_VALUE;
      assemble(0, 0, map.get(items.get(0)).get(0).quality);
      System.out.println(maxQ);
    }
  }

  private static class Component {
    private String name;
    private long price;
    private long quality;
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
