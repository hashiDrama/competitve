package cfLiveRounds.ECR92;

import java.util.Scanner;

public class LCMProblem {

  private static int gcd(int a, int b) {
    if (a == 0) {
      return b;
    }
    return gcd(b % a, a);
  }

  private static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      int i = 0, j = 0;
      boolean found = false;
      for (i = l; i < r; i++) {
        for (j = i + 1; j <= r; j++) {
          int temp = lcm(i, j);
          if (temp >= l && temp <= r) {
            found = true;
            break;
          }
        }
        if (found) {
          break;
        }
      }
      if (found) {
        System.out.println(i + " " + j);
      } else {
        System.out.println(-1 + " " + -1);
      }
    }
    sc.close();
  }
}
