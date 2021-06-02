package juniorSheet.cfB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DifferentIsGood {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s = sc.next();
    if (n > 26) {
      System.out.println(-1);
    } else {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
        if (!map.containsKey(c))
          map.put(c, 1);
        map.compute(c, (k, i) -> i++);
      }
      System.out.println(n - map.size());
    }
    sc.close();
  }
}
