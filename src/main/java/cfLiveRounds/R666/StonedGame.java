package cfLiveRounds.R666;

import java.util.Scanner;

public class StonedGame {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      if (n % 2 == 0) {
        boolean eq = true;
        for (int i = 0; i < n - 1; i++) {
          if (a[i] != a[i + 1]) {
            eq = false;
          }
          if (!eq) {
            break;
          }
        }
        System.out.println(eq ? "HL" : "T");
      } else {
        System.out.println("T");
      }
    }
    sc.close();
  }
}
