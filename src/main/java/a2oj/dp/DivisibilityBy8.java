/*
 * https://codeforces.com/problemset/problem/550/C
 */
package a2oj.dp;

import java.util.Scanner;

public class DivisibilityBy8 {

  private static int solve(String s) {
    int n = s.length();
    int num = 0;
    for (int i = 0; i < n; i++) {
      num = s.charAt(i) - '0';
      if (num % 8 == 0)
        return num;
      for (int j = i + 1; j < n; j++) {
        num = num * 10 + s.charAt(j) - '0';
        if (num % 8 == 0)
          return num;
        for (int k = j + 1; k < n; k++) {
          num = num * 10 + s.charAt(k) - '0';
          if (num % 8 == 0)
            return num;
          num /= 10;
        }
        num /= 10;
      }
      num /= 10;
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ans = solve("" + n);
    if (ans == -1)
      System.out.println("NO");
    else {
      System.out.println("YES");
      System.out.println(ans);
    }
    sc.close();
  }
}
