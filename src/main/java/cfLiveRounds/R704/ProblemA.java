/*
 * https://codeforces.com/contest/1492/problem/0
 */
package cfLiveRounds.R704;

import java.util.Scanner;

public class ProblemA {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int p = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      int x = p % a;
      int y = p % b;
      int z = p % c;
      if (x == 0 || y == 0 || z == 0)
        System.out.println(0);
      else
        System.out.println(Math.min(a - x, Math.max(b - y, c - z)));
    }
    sc.close();
  }
}