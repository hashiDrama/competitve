/*
 * https://codeforces.com/contest/459/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class PashmakAndFlowers {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] b = new int[n];
    int max = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
      min = Math.min(min, b[i]);
      max = Math.max(max, b[i]);
    }
    System.out.print((max - min) + " ");
    long mini = 0, maxi = 0;
    for (int i = 0; i < n; i++) {
      if (b[i] == min)
        mini++;
      if (b[i] == max)
        maxi++;
    }
    if (max == min)
      System.out.println((maxi * (maxi - 1)) / 2);
    else
      System.out.println(maxi * mini);
    sc.close();
  }
}
