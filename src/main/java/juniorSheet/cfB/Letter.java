/*
 * https://codeforces.com/contest/43/problem/B
 */
package juniorSheet.cfB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Letter {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s1.toCharArray()) {
      if (!map.containsKey(c))
        map.put(c, 0);
      map.compute(c, (k, v) -> v + 1);
    }
    boolean possible = true;
    for (char c : s2.toCharArray()) {
      if (!map.containsKey(c) || (map.get(c) <= 0 && c != ' ')) {
        possible = false;
        break;
      } else {
        map.compute(c, (k, v) -> v - 1);
      }
    }
    System.out.println(possible ? "YES" : "NO");
    sc.close();
  }
}
