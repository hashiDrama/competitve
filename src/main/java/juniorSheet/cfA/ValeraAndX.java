package juniorSheet.cfA;

import java.util.Scanner;

public class ValeraAndX {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] data = new String[n];
    for (int i = 0; i < n; i++) {
      data[i] = sc.next();
    }
    char c = data[0].charAt(0);
    boolean formX = true;
    for (int i = 0; i < n; i++) {
      if (data[i].charAt(i) != c || data[i].charAt(n - i - 1) != c) {
        formX = false;
        break;
      }
    }
    if (formX) {
      char c1 = data[0].charAt(1);
      for (int i = 0; i < n; i++) {
        if (formX) {
          char[] ch = data[i].toCharArray();
          for (int j = 0; j < n; j++) {
            if (j != i && j != n - i - 1) {
              if (ch[j] != c1 || ch[j] == c) {
                formX = false;
                break;
              }
            }
          }
        } else {
          break;
        }
      }
    }
    System.out.println(formX ? "YES" : "NO");
    sc.close();
  }
}
