/*
 * https://practice.geeksforgeeks.org/problems/word-break1352/1
 */
package gfg.sheet.dp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordBreak {

  private static Map<String, Boolean> mem;

  public static int wordBreak(String a, List<String> b) {
    return canCreate(a, b) ? 1 : 0;
  }

  private static boolean canCreate(String a, List<String> b) {
    if (a.isEmpty())
      return true;
    if (mem.containsKey(a))
      return mem.get(a);
    for (String s : b) {
      if (a.startsWith(s) && canCreate(a.substring(s.length()), b))
        return true;
    }
    mem.put(a, false);
    return false;
  }

  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    List<String> b = new ArrayList<>();
//    for (int i = 0; i < n; i++)
//      b.add(sc.next());
//    String a = sc.next();
//    mem = new HashMap<>();
//    System.out.println(wordBreak(a, b));
//    sc.close();
    Deque<Integer> q = new LinkedList<Integer>();
  }
}
