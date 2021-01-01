/*
 * SPOJ- DIE HARD; link -> https://www.spoj.com/problems/DIEHARD/
 */
package a2oj.dp;

import java.util.Scanner;

public class DieHard {

  private static Integer[][][] mem;

  /**
   * move: 0 - A; 1 - W; 2 - F
   */
  private static int solve(int h, int a, int move) {
    if (h <= 0 || a <= 0)
      return 0;
    if (mem[h][a][move] != null)
      return mem[h][a][move];
    int ans = 1;
    if (move == 0)
      ans += Math.max(solve(h - 5, a - 10, 1), solve(h - 20, a + 5, 2));
    else if (move == 1)
      ans += Math.max(solve(h + 3, a + 2, 0), solve(h - 20, a + 5, 2));
    else
      ans += Math.max(solve(h + 3, a + 2, 0), solve(h - 5, a - 10, 1));
    return mem[h][a][move] = ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int h = sc.nextInt();
      int a = sc.nextInt();
      mem = new Integer[2000][2000][3];
      int ans = Math.max(solve(h + 3, a + 2, 0),
          Math.max(solve(h - 5, a - 10, 1), solve(h - 20, a + 5, 2)));
      System.out.println(ans);
    }
    sc.close();
  }
}
