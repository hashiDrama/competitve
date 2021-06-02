/*
 * https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 */
package gfg.sheet.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication {

  private static int[][] mem;

  private static int solve(int[] a, int i, int j) {
    if (i >= j)
      return 0;
    if (mem[i][j] != -1)
      return mem[i][j];
    int max = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      int tempAns = solve(a, i, k) + solve(a, k + 1, j) + a[i - 1] * a[k] * a[j];
      max = Math.max(max, tempAns);
    }
    mem[i][j] = max;
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    int ans = solve(a, 1, n - 1);
    System.out.println(ans);
    sc.close();
  }
}
