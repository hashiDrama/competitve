/*
 * https://www.geeksforgeeks.org/minimum-removals-array-make-max-min-k/
 */
package gfg.sheet.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinRemovals {

  private static int n, k, a[], mem[][];

  private static int check(int i, int removed, int j) {
    if (i > j || i >= n || j < 0)
      return 0;
    if (a[j] - a[i] <= k)
      return removed;
    return Math.min(check(i + 1, removed + 1, j), check(i, removed + 1, j - 1));
  }

  //Better way
  private static int check(int i, int j) {
    if (i >= j || a[j] - a[i] <= k)
      return 0;
    if (mem[i][j] != -1)
      return mem[i][j];
    return mem[i][j] = 1 + Math.min(check(i + 1, j), check(i, j - 1));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    k = sc.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    Arrays.sort(a);
    // System.out.println(check(0, 0, n - 1));
    mem = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++)
      Arrays.fill(mem[i], -1);
    System.out.println(check(0, n - 1));
    sc.close();
  }
}
