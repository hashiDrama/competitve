/*
 * https://codeforces.com/contest/706/problem/B
 */
package juniorSheet.cfB;

import java.util.Arrays;
import java.util.Scanner;

public class InterestingDrink {

  private static int solve(int[] a, int v) {
    if(v < a[0]) return 0;
    int l = 0, r = a.length;
    int mid = (l + r) / 2;
    while (l < r) {
      if (a[mid] <= v)
        l = mid + 1;
      else
        r = mid;
      mid = (l + r) / 2;
    }
    return l;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    Arrays.sort(a);
    int q = sc.nextInt();
    int m;
    while (q-- > 0) {
      m = sc.nextInt();
      System.out.println(solve(a, m));
    }
    sc.close();
  }
}
