package juniorSheet.cfB;

import java.util.Scanner;

public class Pi {

  private static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      double t = (double) n * (n - 1) / 2;
      int pairs = 0;
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (gcd(a[i], a[j]) == 1) {
            pairs++;
          }
        }
      }
      if (pairs != 0) {
        Double ans = Math.sqrt((6 * t) / pairs);
        System.out.printf("%.6f\n", ans);
      } else {
        System.out.println("No estimate for this data set.");
      }
    }
    sc.close();
  }
}
