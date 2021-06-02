/*
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=129
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class GraphColoring {

  private static List<List<Integer>> adjList;
  private static int n;
  private static Set<Integer> bestBlacks, curBlacks;
  private static boolean[] curColor; // true for black, false for white

  private static boolean canBeBlack(int cur) {
    for (int nei : adjList.get(cur)) {
      if (nei == cur || curColor[nei]) {
        return false;
      }
    }
    return true;
  }

  // Max independent set is NP-complete
  // 2^100 = TLE ... note very weak test cases, it will pass
  private static void backtrack_1(int cur) {
    if (cur == n) {
      if (bestBlacks.size() < curBlacks.size()) {
        bestBlacks = new HashSet<>(curBlacks);
      }
      return;
    }
    backtrack_1(cur + 1); // leave it white
    if (canBeBlack(cur)) {
      curColor[cur] = true;
      curBlacks.add(cur);

      backtrack_1(cur + 1);

      curBlacks.remove(cur);
      curColor[cur] = false;
    }
  }

  private static void backtrack_2(int cur) {
    if (cur == n) { // marked all?
      if (bestBlacks.size() < curBlacks.size()) {
        bestBlacks = new HashSet<>(curBlacks);
      }
      return;
    }
    int maxPossibleBlack = n - cur;
    if (maxPossibleBlack + curBlacks.size() <= bestBlacks.size())
      return; // pruning: even if all next are black, we won't do well.

    if (canBeBlack(cur)) { // switch to black
      // do..rec..undo
      curColor[cur] = true;
      curBlacks.add(cur);

      backtrack_2(cur + 1);

      curBlacks.remove(cur);
      curColor[cur] = false;
    }

    // optimization: let the black calls be first, they help pruning happens more.
    // tip: order of tracking calls matter a lot when you have pruning.
    backtrack_2(cur); // leave it white
  }

  // max depth = max # of blacks
  private static void backtrack_3(int cur) {
    if (bestBlacks.size() < curBlacks.size()) {
      bestBlacks = new HashSet<>(curBlacks); // you have to check earlier..you may not reach cur = n
    }

    if (cur == n)
      return;

    int maxPossibleBlack = n - cur;
    if (maxPossibleBlack + curBlacks.size() <= bestBlacks.size())
      return; // pruning: even if all next are black, we won't do well.

    for (int i = cur; i < n; i++) {
      if (canBeBlack(i)) { // switch to black
        // do..rec..undo
        curColor[i] = true;
        curBlacks.add(i);

        backtrack_3(i + 1);

        curBlacks.remove(i);
        curColor[i] = false;
      }
    }
    // no need to call specific white, loop do so
  }

  // What else?
  // Trick 1: randomization
  // Instead of following normal order...randomize the order
  // e.g. use order: 5 2 0 1 3 4

  // Trick 2: Greedy order
  // Sort nodes order based on its degree: less degree first.

  // More: run several randomization, each for few recursion steps...and have initial bound for
  // answer.
  // then do the Trick 1 again.

  // As N = 100, we can use bits to represent states...and check for canBeBlack.

  // Have some good ordering, use DP with last 20 nodes, and use backtracking with n-20 nodes.


  public static void main(String[] args) {
    FastReader reader = new FastReader();
    int t = reader.nextInt();
    while (t-- > 0) {
      n = reader.nextInt();
      int k = reader.nextInt();
      adjList = new ArrayList<>();
      for (int i = 0; i < n; i++)
        adjList.add(new ArrayList<>());
      bestBlacks = new HashSet<>();
      curBlacks = new HashSet<>();
      curColor = new boolean[n];
      int f, to;
      for (int i = 0; i < k; i++) {
        f = reader.nextInt();
        to = reader.nextInt();
        adjList.get(f - 1).add(to - 1);
        adjList.get(to - 1).add(f - 1);
      }

      backtrack_3(0);
      System.out.println(bestBlacks.size());
      List<Integer> ans = new ArrayList<>(bestBlacks);
      int i;
      for (i = 0; i < ans.size() - 1; i++)
        System.out.print((ans.get(i) + 1) + " ");
      System.out.println(ans.get(i) + 1);
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
