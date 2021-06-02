/*
 * https://codeforces.com/contest/285/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class FindMarble {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int s = sc.nextInt();
    int t = sc.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++)
      a[i] = sc.nextInt();
    if (s == t) {
      System.out.println(0);
      return;
    }
    int pos = s, op = 0;
    boolean found = false;
    while (op <= n) {
      pos = a[pos];
      op++;
      if (pos == t) {
        found = true;
        break;
      }
    }
    if (found)
      System.out.println(op);
    else
      System.out.println(-1);
    sc.close();
  }
}
