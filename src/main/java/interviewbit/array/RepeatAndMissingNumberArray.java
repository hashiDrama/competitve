/*
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 */
package interviewbit.array;

import java.util.Scanner;

public class RepeatAndMissingNumberArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    long sum = 0;
    long sqSum = 0;
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      sum += a[i];
      sqSum += (a[i] * a[i]);
    }
    double nSum = ((double)n) * (n + 1) / 2;
    double nSqSum = ((double)n * (n + 1) * (2 * n + 1)) / 6;
    double x = ((nSqSum - sqSum) / (nSum - sum)) / 2;
    double y = sum + x - nSum;
    System.out.println(x + " " + y);
    sc.close();
  }
}
