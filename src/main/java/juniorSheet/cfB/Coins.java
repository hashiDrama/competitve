package juniorSheet.cfB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coins {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = new String[3];
    for (int i = 0; i < 3; i++) {
      s[i] = sc.next();
    }
    int[] c = new int[3];
    for (int i = 0; i < 3; i++) {
      if (s[i].contains(">")) {
        c[s[i].charAt(0) - 'A']++;
      } else {
        c[s[i].charAt(2) - 'A']++;
      }
    }
    Map<Integer, Character> map = new HashMap<>();
    map.put(c[0], 'A');
    map.put(c[1], 'B');
    map.put(c[2], 'C');
    if (map.size() < 3) {
      System.out.println("Impossible");
    } else {
      System.out.println("" + map.get(0) + map.get(1) + map.get(2));
    }
    sc.close();
  }
}
