/*
 * https://codeforces.com/contest/136/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class TernaryLogic {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int c = sc.nextInt();
    int b = 0, multiple = 1;
    while (a> 0 || c>0) {
      b += ((c % 3 - a % 3 + 3) % 3) * multiple;
      multiple *= 3;
      a /= 3;
      c /= 3;
    }
    System.out.println(b);
    sc.close();
  }
}
