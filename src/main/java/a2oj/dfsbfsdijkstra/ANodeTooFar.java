/*
 * uva-336 A Node Too Far; link ->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=272
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ANodeTooFar {

  private static Map<Integer, List<Integer>> graph;
  private static Map<Integer, Integer> vis;

  private static void bfs(int u) {
    Queue<Integer> q = new LinkedList<>();
    q.add(u);
    vis.put(u, 0);
    while (!q.isEmpty()) {
      u = q.poll();
      if(!graph.containsKey(u)) continue;
      for (int v : graph.get(u)) {
        if (!vis.containsKey(v)) {
          vis.put(v, vis.get(u) + 1);
          q.add(v);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = 1;
    while (true) {
      int nc = sc.nextInt();
      if (nc == 0)
        break;
      graph = new HashMap<>();
      int n1, n2;
      List<Integer> tempList;
      for (int i = 0; i < nc; i++) {
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        if (graph.containsKey(n1)) {
          tempList = graph.get(n1);
          graph.remove(n1);
        } else {
          tempList = new ArrayList<>();
        }
        tempList.add(n2);
        graph.put(n1, tempList);
        if (graph.containsKey(n2)) {
          tempList = graph.get(n2);
          graph.remove(n2);
        } else {
          tempList = new ArrayList<>();
        }
        tempList.add(n1);
        graph.put(n2, tempList);
      }
      int u, ttl, count;
      while (true) {
        u = sc.nextInt();
        ttl = sc.nextInt();
        if (u == 0 && ttl == 0)
          break;
        vis = new HashMap<>();
        if(graph.containsKey(u))
          bfs(u);
        count = 0;
        for (Integer i : vis.values()) {
          if (i > ttl) {
            count++;
          }
        }
        count += graph.size() - vis.size();
        System.out.println("Case " + (cases++) + ": " + count + " nodes not reachable from node "
            + u + " with TTL = " + ttl + ".");
      }
      sc.nextLine();
      sc.nextLine();
    }
    sc.close();
  }
}
