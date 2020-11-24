/*
 * CF-B; round #339; link -> https://codeforces.com/contest/614/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class GenasCode {

  static boolean isBeautiful(String s) {
    boolean foundOne = false;
    for (char c : s.toCharArray()) {
      if (c == '1') {
        if (foundOne)
          return false; // works for 110, 101(no having more than one '1')
        foundOne = true;
      } else if (c != '0')
        return false;
    }
    return foundOne; // works for 5, 23, 458(no having no 1)
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    StringBuilder ans = new StringBuilder();
    String prefix = "";
    String s = "";
    for (int i = 0; i < n; i++) {
      s = sc.next();
      if (s.equals("0")) {
        System.out.println(0);
        return;
      }
      if (isBeautiful(s)) {
        ans.append(s.substring(1));
      } else {
        prefix = s;
      }
    }
    if (prefix.isEmpty()) {
      System.out.println("1" + ans.toString());
    } else {
      System.out.println(prefix + ans.toString());
    }
    sc.close();
  }
}
