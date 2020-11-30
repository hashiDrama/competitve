package cchefLiveRounds.novLunchtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RookPath {

  private static List<Point> points;
  private static List<List<Integer>> adjList;
  private static boolean[] vis;
  private static List<Integer> traversed;

  private static void dfs(int u, boolean row) {
    if(vis[u])return;
    traversed.add(u);
    vis[u] = true;
    for (int v : adjList.get(u)) {
      if (!vis[v]) {
        if (row) {
          if (points.get(v).x == points.get(u).x) {
            dfs(v, false);
            break;
          }
        } else {
          if (points.get(v).y == points.get(u).y) {
            dfs(v, true);
            break;
          }
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      line = br.readLine();
      int n = Integer.parseInt(line.substring(0, 1));
      int m = Integer.parseInt(line.substring(2, 3));
      points = new ArrayList<>();
      int x, y;
      for (int i = 0; i < m; i++) {
        line = br.readLine();
        x = Integer.parseInt(line.substring(0, 1));
        y = Integer.parseInt(line.substring(2, 3));
        points.add(new Point(x, y));
      }
      adjList = new ArrayList<>();
      for (int i = 0; i < m; i++)
        adjList.add(new ArrayList<>());

      for (int i = 0; i < m - 1; i++) {
        for (int j = i + 1; j < m; j++) {
          if (points.get(i).x == points.get(j).x || points.get(i).y == points.get(j).y) {
            adjList.get(i).add(j);
            adjList.get(j).add(i);
          }
        }
      }
      vis = new boolean[m];
      for (int i = 0; i < m; i++) {
        Arrays.fill(vis, false);
        traversed = new ArrayList<>();
        dfs(i, true);
        if (traversed.size() == m)
          break;
      }
      for (int i = 0; i < m - 1; i++)
        System.out.print((traversed.get(i)+1) + " ");
      System.out.println((traversed.get(m - 1)+1));
    }
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
