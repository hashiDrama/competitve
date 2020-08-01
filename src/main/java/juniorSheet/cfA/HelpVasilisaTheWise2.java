package juniorSheet.cfA;

import java.util.Scanner;

public class HelpVasilisaTheWise2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r1 = sc.nextInt();
    int r2 = sc.nextInt();
    int c1 = sc.nextInt();
    int c2 = sc.nextInt();
    int d1 = sc.nextInt();
    int d2 = sc.nextInt();

    int r00 = 0, r01 = 0, r10 = 0, r11 = 0;
    boolean found = false;
    for (r00 = 1; r00 < 10; r00++) {
      for (r01 = 1; r01 < 10; r01++) {
        if (r00 == r01)
          continue;
        for (r10 = 1; r10 < 10; r10++) {
          if (r10 == r00 || r10 == r01)
            continue;
          for (r11 = 1; r11 < 10; r11++) {
            if (r11 == r00 || r11 == r01 || r11 == r10)
              continue;
            if ((r00 + r01 == r1) && (r10 + r11 == r2) && (r00 + r10 == c1) && (r01 + r11 == c2)
                && (r00 + r11 == d1) && (r01 + r10 == d2)) {
              found = true;
              break;
            }
          }
          if (found)
            break;
        }
        if (found)
          break;
      }
      if (found)
        break;
    }
    if (found) {
      System.out.println(r00 + " " + r01);
      System.out.println(r10 + " " + r11);
    } else {
      System.out.println(-1);
    }
    sc.close();
  }
}
