/*
 * CF-B round #240; link -> https://codeforces.com/contest/415/problem/B
 */

package juniorSheet.cfB;

import java.util.Scanner;

public class MashmokhAndTokens {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long a = sc.nextLong();
    long b = sc.nextLong();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
      System.out.print(((x[i] * a) % b)/a + " ");
    }
    sc.close();
  }
}
