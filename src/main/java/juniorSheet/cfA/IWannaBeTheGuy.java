package juniorSheet.cfA;

import java.util.Scanner;

public class IWannaBeTheGuy {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int p = sc.nextInt();
    for (int i = 0; i < p; i++) {
      a[sc.nextInt() - 1] = 1;
    }
    int q = sc.nextInt();
    for (int i = 0; i < q; i++) {
      a[sc.nextInt() - 1] = 1;
    }
    boolean winner = true;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        winner = false;
        break;
      }
    }
    System.out.println(winner ? "I become the guy." : "Oh, my keyboard!");
    sc.close();
  }
}
