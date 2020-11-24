package juniorSheet.cfB;

import java.util.Scanner;

public class TheDrunkJailer {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      boolean[] b = new boolean[n];
      int round = 1;
      while (round <= n) {
        for (int i = 0; i < n; i++) {
          if ((i + 1) % round == 0) {
            b[i] = !b[i];
          }
        }
        round++;
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (b[i])
          count++;
      }
      System.out.println(count);
    }
    sc.close();
  }
}
