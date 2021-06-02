/*
 * https://codeforces.com/contest/1486/problem/A
 */
package cfLiveRounds.R703;

import java.util.Scanner;

public class ProblemA {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++)
        a[i] = sc.nextInt();
      long sum = 0;
      boolean isPos = true;
      for (int i = 0; i < n; i++) {
        sum += a[i];
        if (sum < i * (i + 1) / 2) {
          isPos = false;
          break;
        }
      }
      if (isPos)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
    sc.close();
  }
}
