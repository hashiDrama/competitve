/*
 * CF-217-A; link -> https://codeforces.com/problemset/problem/217/A
 * 
 * Algo:-
 * All the points having same x or y coordinate will share an edge.
 * This way we can create a graph.
 * Now, count the strongly connected components in this graph.
 * This count-1 will be the # of new drifts needed to be created.
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IceSkating {

  private static int n;
  private static List<List<Integer>> graph;
  private static boolean[] vis;

  private static void dfs(int i) {
    vis[i] = true;
    for (int t = 0; t < graph.get(i).size(); t++) {
      if (!vis[graph.get(i).get(t)]) {
        dfs(graph.get(i).get(t));
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      points.add(new Point(sc.nextInt(), sc.nextInt()));
    }
    graph = new ArrayList<>();
    for(int i=0; i<n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (points.get(i).x == points.get(j).x || points.get(i).y == points.get(j).y) {
          graph.get(i).add(j);
          graph.get(j).add(i);
        }
      }
    }
    vis = new boolean[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        dfs(i);
        count++;
      }
    }
    System.out.println(count - 1);
    sc.close();
  }

  private static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
