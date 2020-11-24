/*
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3104
 */

package a2oj.dfsbfsdijkstra;

import java.util.Scanner;

public class Battleships {
  
  private static char[][] grid;
  private static boolean[][] vis;
  private static int n;
  private static boolean isShip;
  
  private static boolean valid(int i, int j) {
    return i>=0 && i<n && j>= 0 && j<n;
  }
  
  private static void dfs(int i, int j) {
    if(!valid(i, j) || vis[i][j] || grid[i][j] == '.')
      return;
    vis[i][j] = true;
    if(grid[i][j] == 'x') {
      isShip = true;
    }
    dfs(i-1, j);
    dfs(i, j-1); dfs(i, j+1);
    dfs(i+1, j);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int counter = 1;
    while(t-- > 0) {
      n = sc.nextInt();
      grid = new char[n][n];
      String line;
      for(int i=0; i<n; i++) {
        line = sc.next();
        int j = 0;
        for(char c : line.toCharArray()) {
          grid[i][j] = c;
          j++;
        }
      }
      vis = new boolean[n][n];
      int count = 0;
      for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
          if(!vis[i][j]) {
            isShip = false;
            dfs(i,j);
            if(isShip)
              count++;
          }
        }
      }
      System.out.println("Case " + counter + ": " + count);
      counter++;
    }
    sc.close();
  }
}
