/*
 * https://codeforces.com/contest/651/problem/B
 */
package juniorSheet.cfB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BeautifulPaintings {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      if (!map.containsKey(a[i]))
        map.put(a[i], 0);
      map.compute(a[i], (k, v) -> v = v + 1);
      max = Math.max(max, map.get(a[i]));
    }
    System.out.println(n - max);
    sc.close();
  }
}
