/*
 * CFB round # 281; link -> 
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class VasyaAndWrestling {

  private static final String NONE = "none";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long w1 = 0, w2 = 0;
    long[] a1 = new long[n];
    long[] a2 = new long[n];
    long p, lastP = 0;
    int i1 = 0, i2 = 0;
    for (int i = 0; i < n; i++) {
      p = sc.nextInt();
      if (p > 0) {
        w1 += p;
        a1[i1++] = p;
      } else {
        w2 += (-1) * p;
        a2[i2++] = (-1) * p;
      }
      if (i == n - 1)
        lastP = p;
    }
    String winner = NONE;
    if (w1 > w2)
      winner = "first";
    else if (w1 < w2)
      winner = "second";
    else {
      for (int i = 0; i < n; i++) {
        if (a1[i] > a2[i]) {
          winner = "first";
          break;
        } else if (a1[i] < a2[i]) {
          winner = "second";
          break;
        }
      }
      if (winner.equals(NONE)) {
        if (lastP > 0)
          winner = "first";
        else
          winner = "second";
      }
    }
    System.out.println(winner);
    sc.close();
  }
}
