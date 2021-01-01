/*
 * uva-785 Grid Coloring; link->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=726
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GridColouring {

  private static char[][] grid;
  private static int r, c;
  private static boolean[][] vis;

  private static int[] di = new int[] {0, -1, 0, 1};
  private static int[] dj = new int[] {-1, 0, 1, 0};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < r && j >= 0 && j < c;
  }

  private static void bfs(int i, int j, char mark) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    q.add(j);
    int ni, nj;
    while (!q.isEmpty()) {
      i = q.poll();
      j = q.poll();
      if (vis[i][j])
        continue;
      vis[i][j] = true;
      grid[i][j] = mark;
      for (int t = 0; t < 4; t++) {
        ni = i + di[t];
        nj = j + dj[t];
        if (valid(i, j) && grid[i][j] != 'X' && !vis[i][j]) {
          q.add(ni);
          q.add(nj);
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNextLine()) {
      List<String> line = new ArrayList<>();
      String nextLine;
      while (true) {
        nextLine = sc.nextLine();
        if (nextLine.contains("_"))
          break;
        line.add(nextLine);
      }
      sc.nextLine();
      r = line.size();
      c = line.get(0).length();
      grid = new char[r][c];

      for (int i = 0; i < r; i++) {
        grid[i] = line.get(i).toCharArray();
      }
      vis = new boolean[r][c];
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (!vis[i][j] && grid[i][j] != 'X' && grid[i][j] != ' ') {
            bfs(i, j, grid[i][j]);
          }
        }
      }
    }
    sc.close();
  }
}
