/*
 * https://codeforces.com/contest/596/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class WilburAndArray {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long prev, curr;
    prev = sc.nextInt();
    long count = Math.abs(prev);
    for (int i = 1; i < n; i++) {
      curr = sc.nextInt();
      count += Math.abs(prev - curr);
      prev = curr;
    }
    System.out.println(count);
    sc.close();
  }
}
