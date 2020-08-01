package juniorSheet.cfA;

import java.util.Scanner;

public class Football {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String t1 = "", t2 = "", t;
    int c1 = 0, c2 = 0;
    for (int i = 0; i < n; i++) {
      t = sc.next();
      if (t1.isEmpty()) {
        t1 = t;
        c1++;
      } else if (!t.equals(t1) && t2.isEmpty()) {
        t2 = t;
        c2++;
      } else if (t.equals(t1)) {
        c1++;
      } else if (t.equals(t2)) {
        c2++;
      }
    }
    System.out.println(c1 > c2 ? t1 : t2);
    sc.close();
  }
}
