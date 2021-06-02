/*
 * https://codeforces.com/contest/465/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class Inbox {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    int op = 0;
    for (int i = 0; i < n - 1; i++) {
      if (a[i] == 1) {
        op++;
        if (a[i + 1] != 1)
          op++;
      }
    }
    if (a[n - 1] == 1)
      op++;
    else
      op--;
    System.out.println(op < 0 ? 0 : op);
    sc.close();
  }
}
