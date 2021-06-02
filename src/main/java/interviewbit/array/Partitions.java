/*
 * https://www.interviewbit.com/problems/partitions/
 */
package interviewbit.array;

import java.util.Scanner;

public class Partitions {

  private static int solve(int n, int[] a) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
    }
    if (sum % 3 != 0)
      return 0;
    sum /= 3;

    int[] p, s;
    int count = 0;
    p = new int[n];
    s = new int[n];
    p[0] = a[0];
    s[n - 1] = a[n - 1];
    for (int i = 1; i < n; i++) {
      p[i] = p[i - 1] + a[i];
    }
    for (int i = n - 2; i >= 0; i--)
      s[i] = s[i + 1] + a[i];
    for (int i = 0; i < n - 2; i++) {
      if (p[i] == sum) {
        for (int j = i + 2; j < n; j++) {
          if (s[j] == sum)
            count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    System.out.println(solve(n, a));
    sc.close();
  }
}
