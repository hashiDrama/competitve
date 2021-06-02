/*
 * https://codeforces.com/contest/732/problem/B
 */
package juniorSheet.cfB;

import java.util.Arrays;
import java.util.Scanner;

public class CormenBestFriendOfMan {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    int add = 0;
    for (int i = 1; i < n; i++) {
      if (a[i - 1] + a[i] < k) {
        add += k - (a[i - 1] + a[i]);
        a[i] = k - a[i - 1];
      }
    }
    System.out.println(add);
    Arrays.stream(a).forEach(i -> System.out.print(i + " "));
    System.out.println();
    sc.close();
  }
}
