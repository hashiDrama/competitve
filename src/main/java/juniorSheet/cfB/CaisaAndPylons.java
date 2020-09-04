package juniorSheet.cfB;

import java.util.Scanner;

public class CaisaAndPylons {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] h = new int[n];
    int hd = 0;
    int amount = 0;
    int e = 0;

    for (int i = 0; i < n; i++) {
      h[i] = sc.nextInt();
    }

    for (int i = 0; i < n - 1; i++) {
      hd = h[i] - h[i + 1];
      if ((e + hd) < 0) {
        amount += Math.abs(hd) - e;
        e = 0;
      } else {
        e += hd;
      }
    }
    System.out.println(amount + h[0]);
    sc.close();
  }
}
