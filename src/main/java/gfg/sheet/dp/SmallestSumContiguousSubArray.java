/*
 * https://www.geeksforgeeks.org/smallest-sum-contiguous-subarray/
 */
package gfg.sheet.dp;

import java.util.Scanner;

public class SmallestSumContiguousSubArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    int min = a[0], sum = a[0];
    for (int i = 1; i < n; i++) {
      sum = Math.min(a[i], sum + a[i]);
      min = Math.min(min, sum);
    }
    System.out.println(min);
    sc.close();
  }
}
