/*
 * CF-750A New Year And Hurry link -> http://codeforces.com/problemset/problem/750/A
 */
package a2oj.dp;

import java.util.Scanner;

public class NewYearAndHurry {

  private static int count(int i, int time, int k, int n) {
    if (i > n)
      return 0;
    time += 5 * i;
    if (time > 240 - k)
      return 0;
    return 1 + count(i + 1, time, k, n);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    System.out.println(count(1, 0, k, n));
    sc.close();
  }
}
