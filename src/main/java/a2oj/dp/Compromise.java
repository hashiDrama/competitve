/*
 * UVA - Compromise; link -> https://onlinejudge.org/external/5/531.pdf
 */
package a2oj.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Compromise {

  private static String[] s1, s2;
  private static int[][] mem;

  private static List<String> solve(int i, int j) {
    if (i < 0 || i >= s1.length || j < 0 || j >= s2.length)
      return Collections.emptyList();

    List<String> ans = new ArrayList<>();
    if (s1[i].equals(s2[j])) {
      ans.add(s1[i]);
      ans.addAll(solve(i + 1, j + 1));
    } else {
      List<String> l1 = solve(i + 1, j);
      List<String> l2 = solve(i, j + 1);
      List<String> nextMaxSequence = l1.size() > l2.size() ? l1 : l2;
      ans.addAll(nextMaxSequence);
    }
    return ans;
  }

  private static List<String> solve1(String[] s1, String[] s2, int l1, int l2) {
    int[][] dp = new int[l1 + 1][l2 + 1];
    for (int i = 0; i <= l1; i++)
      for (int j = 0; j <= l2; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (s1[i - 1].equals(s2[j - 1]))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    List<String> ans = new ArrayList<>();
    int n = l1, m = l2;
    while (n > 0 && m > 0) {
      if (s1[n - 1].equals(s2[m - 1])) {
        ans.add(s1[n - 1]);
        n--;
        m--;
      } else if (dp[n - 1][m] > dp[n][m - 1])
        n--;
      else
        m--;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      StringBuilder sb = new StringBuilder();
      String line = sc.nextLine();
      while (!line.equals("#")) {
        sb.append(line).append(" ");
        line = sc.nextLine();
      }
      String[] s1 = sb.toString().split(" ");
      sb = new StringBuilder();
      line = sc.nextLine();
      while (!line.equals("#")) {
        sb.append(line).append(" ");
        line = sc.nextLine();
      }
      String[] s2 = sb.toString().split(" ");
      mem = new int[s1.length + 1][s2.length + 2];
      List<String> longestSeq = solve1(s1, s2, s1.length, s2.length);
      int index = longestSeq.size() - 1;
      System.out.print(longestSeq.get(index));
      for (int i = index - 1; i >= 0; i--) {
        System.out.print(" " + longestSeq.get(i));
      }
      System.out.println();
    }
    sc.close();
  }
}
