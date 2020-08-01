package juniorSheet.cfA;

import java.util.Scanner;

public class IQTest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = new String[4];
    for (int i = 0; i < 4; i++) {
      s[i] = sc.nextLine();
    }

    boolean found = false;
    int d, h;
    for (int i = 0; i < 3; i++) {
      d = 0;
      h = 0;
      for (int j = 0; j < 3; j++) {
        d = 0;
        h = 0;
        if (s[i].charAt(j) == '.') {
          d++;
        } else {
          h++;
        }
        if (s[i].charAt(j + 1) == '.') {
          d++;
        } else {
          h++;
        }
        if (s[i + 1].charAt(j) == '.') {
          d++;
        } else {
          h++;
        }
        if (s[i + 1].charAt(j + 1) == '.') {
          d++;
        } else {
          h++;
        }
        if (d == 4 || d == 3 || h == 4 || h == 3) {
          found = true;
          break;
        }
      }
      if (found) {
        break;
      }
    }
    if (found) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    sc.close();
  }
}
