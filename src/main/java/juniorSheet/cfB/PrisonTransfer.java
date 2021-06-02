/*
 * https://codeforces.com/contest/427/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class PrisonTransfer {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int t = sc.nextInt();
    int c = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    int count = 0, ways = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] <= t)
        count++;
      else {
        if (count >= c) {
          ways += count - c + 1;
        }
        count = 0;
      }
    }
    if (count >= c) {
      ways += count - c + 1;
    }
    System.out.println(ways);
    sc.close();
  }
}
