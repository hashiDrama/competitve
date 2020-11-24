/*
 * uva-11503, link -> https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2498
 */

package juniorSheet.cfB;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualFriends {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      DisjointSet ds = new DisjointSet();
      for (int i = 0; i < n; i++) {
        String name1 = sc.next();
        String name2 = sc.next();
        if (!ds.parent.containsKey(name1)) {
          ds.parent.put(name1, name1);
          ds.rank.put(name1, 1);
        }
        if (!ds.parent.containsKey(name2)) {
          ds.parent.put(name2, name2);
          ds.rank.put(name2, 1);
        }
        System.out.println(ds.unionSet(name1, name2));
      }
    }
    sc.close();
  }
}


class DisjointSet {
  Map<String, String> parent;
  Map<String, Integer> rank;

  public DisjointSet() {
    this.parent = new HashMap<>();
    this.rank = new HashMap<>();
  }

  public String findSet(String name) {
    if (name.equals(parent.get(name)))
      return name;
    parent.replace(name, findSet(parent.get(name)));
    return parent.get(name);
  }

  public int unionSet(String name1, String name2) {
    String p1 = findSet(name1);
    String p2 = findSet(name2);
    if(p1.equals(p2)) {
      return rank.get(p1);
    }
    Integer r1 = rank.get(p1);
    Integer r2 = rank.get(p2);

    if (r1 > r2) {
      parent.replace(p2, p1);
      rank.replace(p1, r1+r2);
    } else {
      parent.replace(p1, p2);
      rank.replace(p2, r1+r2);
    }
    return Math.max(rank.get(p1), rank.get(p2));
  }
}
