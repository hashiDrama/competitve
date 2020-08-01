package juniorSheet.cfA;

import java.util.Scanner;

public class FancyFence {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int a = sc.nextInt();
      if (360 % (180 - a) != 0) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
    sc.close();
  }
}
