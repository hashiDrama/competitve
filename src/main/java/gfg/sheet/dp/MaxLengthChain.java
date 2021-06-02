/*
 * https://practice.geeksforgeeks.org/problems/max-length-chain/1#
 */
package gfg.sheet.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxLengthChain {

  private static int lis(Pair[] a, int n) {
    int[] dp = new int[n + 1];
    int ans = 0;
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (a[i].x > a[j].y)
          dp[i] = Math.max(dp[i], dp[j] + 1);
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Pair[] a = new Pair[n];
    for (int i = 0; i < n; i++) {
      a[i] = new Pair(sc.nextInt(), sc.nextInt());
    }
    Arrays.sort(a, new CompareByFirst());
    System.out.println(lis(a, n));
    sc.close();
  }
}


class Pair {
  int x, y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}


class CompareByFirst implements Comparator<Pair> {
  public int compare(Pair a, Pair b) {
    return a.x - b.y;
  }
}
