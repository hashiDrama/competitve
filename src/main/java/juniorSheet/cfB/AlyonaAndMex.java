/*
 * https://codeforces.com/contest/682/problem/B
 */
package juniorSheet.cfB;

import java.util.Arrays;
import java.util.Scanner;

public class AlyonaAndMex {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Integer[] a = new Integer[n];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    Arrays.sort(a);
    int cur = 1;
    for (int i = 0; i < n; i++)
      if (a[i] >= cur)
        cur++;
    System.out.println(cur);
    sc.close();
  }
}
