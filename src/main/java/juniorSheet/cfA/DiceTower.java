package juniorSheet.cfA;

import java.util.Scanner;

public class DiceTower {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    boolean possible = true;
    for (int i = 0; i < n; i++) {
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      if (possible) {
        if (n1 == x || n1 == 7 - x || n2 == x || n2 == 7 - x) {
          possible = false;
        }
      }
    }
    if (possible) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    sc.close();
  }
}
