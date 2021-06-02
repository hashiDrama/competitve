/*
 * https://codeforces.com/contest/1494/problem/A
 */
package cfLiveRounds.ECR105;

import java.util.Scanner;

public class ProblemA {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      int n = s.length();
      int[] c = new int[3];
      for (char ch : s.toCharArray()) {
        c[ch - 'A']++;
      }
      boolean ans = true;
      if (s.charAt(0) == s.charAt(n - 1)) {
        ans = false;
      } else {
        for (int i = 0; i < 3; i++) {
          if (c[i] > n / 2) {
            ans = false;
            break;
          }
        }
      }
      System.out.println(ans ? "YES" : "NO");
    }
    sc.close();
  }
}
