/**
 * https://codeforces.com/contest/1473/problem/A
 */
package cfLiveRounds.ECR102;

import java.util.Arrays;
import java.util.Scanner;

public class P1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int d = sc.nextInt();
      int[] a = new int[n];
      boolean greater = false;
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
        if (a[i] > d)
          greater = true;
      }
      if (!greater) {
        System.out.println("YES");
        continue;
      }
      Arrays.sort(a);
      if (a[0] + a[1] > d)
        System.out.println("NO");
      else
        System.out.println("YES");
    }
    sc.close();
  }
}
