
/*
 * Link -> https://onlinejudge.org/external/104/10496.pdf
 * 
 * Karel is a robot who lives in a rectangular coordinate system where each place is designated by a
 * set of integer coordinates (x and y). Your job is to design a program that will help Karel pick
 * up a number of beepers that are placed in her world. To do so you must direct Karel to the
 * position where each beeper is located. Your job is to write a computer program that finds the
 * length of the shortest path that will get Karel from her starting position, to each of the
 * beepers, and return back again to the starting position.
 * 
 * Karel can only move along the x and y axis, never diagonally. Moving from one position (i, j) to
 * an adjacent position (i, j + 1), (i, j − 1), (i − 1, j), or (i + 1, j) has a cost of one.
 * 
 * You can assume that Karel’s world is never larger than 20 × 20 squares and that there will never
 * be more than 10 beepers to pick up. Each coordinate will be given as a pair (x, y) where each
 * value will be in the range 1 through the size of that particular direction of the coordinate
 * system.
 * 
 */

package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Solution using Backtracking and considering all the ways. This will be very slow and will not
 * work due to exponential complexity.
 * 
 * @author VikrantS
 *
 */

// public class CollectingBeepers {
//
// static int n, m, b, min = Integer.MAX_VALUE;
// static boolean beepers[][];
// static boolean vis[][];
// static int rs, cs;
//
// static boolean valid(int r, int c) {
// return r >= 0 && c >= 0 && r < n && c < m;
// }
//
// static void findShortestPath(int r, int c, int count, int path, int idx) {
// if (!valid(r, c) || vis[r][c])
// return;
// if (beepers[r][c]) {
// path += count;
// idx++;
// if (idx == b) {
// path += Math.abs(r - rs) + Math.abs(c - cs);
// min = min > path ? path : min;
// return;
// }
// count = 1;
// beepers[r][c] = false;
// } else {
// count++;
// }
// vis[r][c] = true;
// findShortestPath(r - 1, c, count, path, idx);
// findShortestPath(r, c + 1, count, path, idx);
// findShortestPath(r + 1, c, count, path, idx);
// findShortestPath(r, c - 1, count, path, idx);
// vis[r][c] = false;
// }
//
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int t = sc.nextInt();
// while (t-- > 0) {
// n = sc.nextInt();
// m = sc.nextInt();
// rs = sc.nextInt() - 1;
// cs = sc.nextInt() - 1;
// b = sc.nextInt();
//
// vis = new boolean[n][m];
// beepers = new boolean[n][m];
// for (int i = 0; i < n; i++)
// for (int j = 0; j < m; j++) {
// vis[i][j] = false;
// beepers[i][j] = false;
// }
// int br, bc;
// for (int i = 0; i < b; i++) {
// br = sc.nextInt();
// bc = sc.nextInt();
// beepers[br - 1][bc - 1] = true;
// }
// findShortestPath(rs, cs, 1, 0, 0);
// System.out.println("The shortest path has length " + min);
// }
// sc.close();
// }
// }

class Point {
  int r;
  int c;

  public Point(int r, int c) {
    this.r = r;
    this.c = c;
  }
}

public class CollectingBeepers {

  static int min = Integer.MAX_VALUE, b;
  static boolean[] vis;
  static List<List<Integer>> distances;

  static void fps(int u, int count) {
    if (u == b + 1) {
      min = min > count ? count : min;
      return;
    }
    if (vis[u])
      return;
    vis[u] = true;
    for (int i = 0; i < distances.get(u).size(); i++) {
      if (!vis[i]) {
        count += distances.get(u).get(i);
        fps(i, count);
      }
    }
    vis[u] = false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int rs = sc.nextInt() - 1;
      int cs = sc.nextInt() - 1;
      b = sc.nextInt();
      Point[] points = new Point[b + 2];
      int rb, cb;
      points[0] = new Point(rs, cs);
      for (int i = 1; i < b + 1; i++) {
        rb = sc.nextInt() - 1;
        cb = sc.nextInt() - 1;
        points[i] = new Point(rb, cb);
      }
      points[b+1] = points[0];

      // Calculate and add the distances of all points from each other.
      distances = new ArrayList<>();
      for (int i = 0; i < b + 2; i++) {
        List<Integer> someList = new ArrayList<>();
        for (int j = 0; j < b + 2; j++) {
          int distance = Math.abs(points[i].r - points[j].r) + Math.abs(points[i].c - points[j].c);
          someList.add(distance);
        }
        distances.add(someList);
      }
      vis = new boolean[b + 2];
      fps(0, 0);
      System.out.println(min);
    }
    sc.close();
  }
}
