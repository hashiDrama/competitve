/*
 * https://codeforces.com/contest/796/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class FindTheBone {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] h = new int[n + 1];
    for (int i = 0; i < m; i++)
      h[sc.nextInt()]++;
    int i = 0, pos = 1, u, v;
    while (i < k) {
      i++;
      u = sc.nextInt();
      v = sc.nextInt();
      if (h[pos] > 0)
        continue;
      if (u != pos && v != pos)
        continue;
      pos = pos != u ? u : v;
    }
    System.out.println(pos);
    sc.close();
  }
}
