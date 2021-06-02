/*
 * https://codeforces.com/contest/501/problem/B
 */
package juniorSheet.cfB;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MishaAndChangingHandles {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q = sc.nextInt();
    Map<String, String> map = new HashMap<String, String>();
    Set<String> newSet = new HashSet<String>();
    String OLD, NEW;
    while (q-- > 0) {
      OLD = sc.next();
      NEW = sc.next();
      map.put(OLD, NEW);
      newSet.add(NEW);
    }
    Map<String, String> ans = new HashMap<>();
    String curr;
    for (String key : map.keySet()) {
      if (newSet.contains(key))
        continue;
      curr = map.get(key);
      while (map.containsKey(curr))
        curr = map.get(curr);
      ans.put(key, curr);
    }
    System.out.println(ans.size());
    for (String key : ans.keySet()) {
      System.out.println(key + " " + ans.get(key));
    }
    sc.close();
  }
}
