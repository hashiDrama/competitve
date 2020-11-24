/*
 * CFB round # 196; link -> https://codeforces.com/contest/337/my
 * 
 * solution: https://codeforces.com/blog/entry/8629
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class RoutineProblem {

  static int gcd(int a, int b) {
    if (a == 0)
      return b;
    return gcd(b % a, a);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    double r1 = (double) a / b;
    double r2 = (double) c / d;
    int num, den;
    if (r1 < r2) {
      num = b * c - a * d;
      den = b * c;
    } else if (r1 > r2) {
      num = a * d - b * c;
      den = a * d;
    } else {
      System.out.println(0 + "/" + 1);
      sc.close();
      return;
    }
    int gcdAns = gcd(num, den);
    num = num / gcdAns;
    den = den / gcdAns;
    System.out.println(num + "/" + den);
    sc.close();
  }
}
