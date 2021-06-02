/*
 * https://codeforces.com/contest/137/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class Permutation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n + 1];
    int ip;
    for (int i = 0; i < n; i++) {
      ip = sc.nextInt();
      if (ip > n)
        continue;
      a[ip]++;
    }
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (a[i] == 0)
        count++;
    }
    System.out.println(count);
    sc.close();
  }
}
