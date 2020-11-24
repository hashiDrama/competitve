/*
 * CF-B, round #333; link-> https://codeforces.com/contest/602/problem/B
 */

package juniorSheet.cfB;

import java.util.Scanner;

public class ApproximatingAConstantRange {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    int min, max, maxLength = 0, length;
    for (int i = 0; i < n - 1; i++) {
      length = 1;
      min = a[i];
      max = a[i];
      for (int j = i + 1; j < n; j++) {
        min = Math.min(min, a[j]);
        max = Math.max(max, a[j]);
        if (Math.abs(max - min) > 1)
          break;
        length++;
      }
      maxLength = Math.max(maxLength, length);
    }
    System.out.println(maxLength);
    sc.close();
  }
}
