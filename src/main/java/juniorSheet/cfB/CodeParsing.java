/*
 * https://codeforces.com/contest/255/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class CodeParsing {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] c = sc.next().toCharArray();
    int x = 0, y = 0;
    for (char ch : c) {
      if (ch == 'x')
        x++;
      else
        y++;
    }
    StringBuilder ans = new StringBuilder();
    int left;
    left = Math.abs(x - y);
    char ansChar = x > y ? 'x' : 'y';
    while (left-- > 0)
      ans.append(ansChar);
    System.out.println(ans.toString());
    sc.close();
  }
}
