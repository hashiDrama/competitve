/*
 * SPOJ-Laser Phones; link -> https://www.spoj.com/problems/MLASERP/
 * 
 * Algo:-
 * save source and destination points cows.
 * Use dijkstras
 * start with starting point.
 * For all the adjacent points(same x and same y); set distance= dist[source]+1
 * return dist[dest.x][dest.y]-1;
 */
package a2oj.dfsbfsdijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LaserPhones {

  private static final int inf = Integer.MAX_VALUE;
  private static int w, h;
  private static char[][] grid;
  private static int[][] d;

  private static void bfs(int i, int j) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    q.add(j);
    int x, y, nx, ny;
    d[i][j]=0;
    while (!q.isEmpty()) {
      x = q.poll();
      y = q.poll();
      nx = x;
      ny = y;
      //set distance of all the adjacent points down the current point
      while (nx + 1 < h && grid[nx + 1][y] != '*') {
        if (d[nx + 1][y] > d[x][y] + 1) {
          d[nx + 1][y] = d[x][y] + 1;
          q.add(nx + 1);
          q.add(y);
        }
        nx++;
      }
      nx = x;
      //set distance of all the adjacent points up the current point
      while (nx - 1 >= 0 && grid[nx - 1][ny] != '*') {
        if (d[nx - 1][y] > d[x][y] + 1) {
          d[nx - 1][y] = d[x][y] + 1;
          q.add(nx - 1);
          q.add(y);
        }
        nx--;
      }
     //set distance of all the adjacent points right to the current point
      while (ny + 1 < w && grid[x][ny + 1] != '*') {
        if (d[x][ny + 1] > d[x][y] + 1) {
          d[x][ny + 1] = d[x][y] + 1;
          q.add(x);
          q.add(ny + 1);
        }
        ny++;
      }
      ny = y;
    //set distance of all the adjacent points left to the current point
      while (ny - 1 >= 0 && grid[x][ny - 1] != '*') {
        if (d[x][ny - 1] > d[x][y] + 1) {
          d[x][ny - 1] = d[x][y] + 1;
          q.add(x);
          q.add(ny - 1);
        }
        ny--;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    w = sc.nextInt();
    h = sc.nextInt();
    sc.nextLine();
    grid = new char[h][w];
    boolean first = true;
    int sx = -1, sy = -1, dx = -1, dy = -1;
    for (int i = 0; i < h; i++) {
      grid[i] = sc.nextLine().toCharArray();
    }
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (grid[i][j] == 'C') {
          if (first) {
            sx = i;
            sy = j;
            first = false;
          } else {
            dx = i;
            dy = j;
          }
        }
      } 
    }
    d = new int[h][w];
    for(int i=0; i<h; i++)
      Arrays.fill(d[i], inf);
    bfs(sx, sy);
    System.out.println(d[dx][dy] - 1);
    sc.close();
  }
}
