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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      StringBuilder sb = new StringBuilder();
      String line = sc.nextLine();
      while(!line.equals("#")) {
        sb.append(line).append(" ");
        line = sc.nextLine();
      }
      s1 = sb.toString().split(" ");
      sb = new StringBuilder();
      line = sc.nextLine();
      while(!line.equals("#")) {
        sb.append(line).append(" ");
        line = sc.nextLine();
      }
      s2 = sb.toString().split(" ");
      mem = new int[s1.length+1][s2.length+2];
      List<String> longestSeq = solve(0, 0);
      for (int i = 0; i < longestSeq.size() - 1; i++) {
        System.out.print(longestSeq.get(i) + " ");
      }
      if(!longestSeq.isEmpty())
        System.out.println(longestSeq.get(longestSeq.size() - 1));
    }
    sc.close();
  }
}
