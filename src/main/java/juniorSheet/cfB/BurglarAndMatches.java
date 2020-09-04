package juniorSheet.cfB;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class BurglarAndMatches {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int a, b;
    SortedMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    for (int i = 0; i < m; i++) {
      a = sc.nextInt();
      b = sc.nextInt();
      if (map.containsKey(b)) {
        map.put(b, map.get(b) + a);
      } else {
        map.put(b, a);
      }
    }
    int count = 0, k, v;
    for (Map.Entry<Integer, Integer> key : map.entrySet()) {
      if (n > 0) {
        k = key.getKey();
        v = key.getValue();
        if (v > n) {
          v = n;
        }
        count += v * k;
        n -= v;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
