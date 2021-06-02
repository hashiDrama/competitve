/*
 * https://codeforces.com/contest/26/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class RegularBracketSeq {

  // Way 1: Using Stack
  // public static void main(String[] args) {
  // Scanner sc = new Scanner(System.in);
  // String s = sc.next();
  // int ans = 0;
  // Stack<Character> st = new Stack<>();
  // for (char c : s.toCharArray()) {
  // if (c == '(')
  // st.push(c);
  // else if (!st.isEmpty()) {
  // st.pop();
  // ans++;
  // }
  // }
  // System.out.println(2 * ans);
  // sc.close();
  // }

  // Way 2
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int ans = 0, count = 0;
    for (char c : s.toCharArray()) {
      if (c == '(')
        count++;
      else if (count > 0) {
        count--;
        ans++;
      }
    }
    System.out.println(2 * ans);
    sc.close();
  }
}
