/*
 * uva-924; link ->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=865
 * 
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SpreadingTheNews {

  private static final int inf = 5000;
  private static List<List<Integer>> adjList;
  private static int n;
  private static int[] d;

  private static void bfs(int u) {
    d = new int[n+1];
    Arrays.fill(d, inf);
    Queue<Integer> q = new LinkedList<>();
    q.add(u);
    d[u] = 0;
    while (!q.isEmpty()) {
      u = q.poll();
      for (int i = 0; i < adjList.get(u).size(); i++) {
        int v = adjList.get(u).get(i);
        if (d[v] == inf) {
          q.add(v);
          d[v] = d[u] + 1;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    adjList = new ArrayList<>();
    int size;
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      size = sc.nextInt();
      for (int j = 0; j < size; j++)
        list.add(sc.nextInt());
      adjList.add(list);
    }
    int t = sc.nextInt();
    int u, maxSize, firstDay;
    for (int i = 0; i < t; i++) {
      u = sc.nextInt();
      if (!adjList.get(u).isEmpty()) {
        bfs(u);
        maxSize = 0;
        firstDay = -1;
        Arrays.sort(d);
        int len = 1;
        for (int j = 1; j <= n; j++) {
          if (d[j - 1] == d[j])
            len++;
          else {
            if (d[j - 1] != inf && len > maxSize) {
              maxSize = len;
              firstDay = d[j - 1];
            }
            len = 1;
          }
        }
        if (firstDay == 0)
          firstDay++;
        System.out.println(maxSize + " " + firstDay);
      } else {
        System.out.println(0);
      }
    }
    sc.close();
  }
}
