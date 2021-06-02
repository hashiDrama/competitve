/**
 * https://codeforces.com/contest/1473/problem/B
 */
package cfLiveRounds.ECR102;

import java.util.Scanner;

public class P2 {

  private static int gcd(int a, int b) {
    if (a == 0)
      return b;
    if (b == 0)
      return a;
    if (a > b)
      return gcd(a - b, b);
    return gcd(a, b - a);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- > 0) {
      String s1 = sc.nextLine();
      String s2 = sc.nextLine();
      int n1 = s1.length(), n2 = s2.length();
      int lcm = (n1 * n2) / gcd(n1, n2);
      int nn1 = lcm / n1, nn2 = lcm / n2;
      StringBuilder sb = new StringBuilder(s1);
      for (int i = 1; i < nn1; i++) {
        sb.append(s1);
      }
      s1 = sb.toString();
      sb = new StringBuilder(s2);
      for (int i = 1; i < nn2; i++) {
        sb.append(s2);
      }
      s2 = sb.toString();
      System.out.println(s1.equals(s2) ? s1 : -1);
    }
    sc.close();
  }
}
