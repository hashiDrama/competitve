package juniorSheet.cfA;

import java.util.Scanner;

public class BrainsPhotos {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    char c;
    boolean colored = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        c = sc.next().charAt(0);
        if (c != ' ' && c == 'C' || c == 'M' || c == 'Y') {
          colored = true;
          break;
        }
      }
    }
    if (!colored) {
      System.out.println("#Black&White");
    } else {
      System.out.println("#Color");
    }
    sc.close();
  }
}
