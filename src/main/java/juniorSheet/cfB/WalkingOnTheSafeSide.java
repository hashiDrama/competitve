// uva-825 link-> https://onlinejudge.org/external/8/825.pdf

package juniorSheet.cfB;

import java.util.Scanner;

public class WalkingOnTheSafeSide {

  static boolean[][] vis;
  static int[][] map;
  static int min;
  static int n, m;

  static boolean valid(int r, int c) {
    return r >= 0 && c >= 0 && r < n && c < m;
  }

  /*
   *  BackTracking approach - It won't work.
   *  We need to find the number of paths for minimal travel which cannot be returned using backtracking.
   *  Either use additional search for all paths having minimal distance or use DP :)
   */
  static void travel(int r, int c, int count) {
    if (!valid(r, c) || vis[r][c] || map[r][c] == 1)
      return;
    if (r == n-1 && c == m-1) {
      min = Math.min(min, count);
      return;
    }

    vis[r][c] = true;
    count++;
    travel(r, c + 1, count);
    travel(r + 1, c, count);
    travel(r, c - 1, count);
    travel(r - 1, c, count);
    vis[r][c] = false;
  }
  
  /*
   * DP approach
   */
  static int[][] minArray;
  static void fastTravel(int r, int c, int count) {
    if (!valid(r, c) || vis[r][c] || map[r][c] == 1)
      return;
    if (r == n-1 && c == m-1) {
      minArray[r][c] = Math.min(minArray[r][c], count);
      min = Math.min(count, min);
      return;
    }
    vis[r][c] = true;
    count++;
    travel(r, c + 1, count);
    travel(r + 1, c, count);
    travel(r, c - 1, count);
    travel(r - 1, c, count);
    vis[r][c] = false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();

    while (t-- > 0) {
      n = sc.nextInt();
      m = sc.nextInt();
      sc.nextLine();
      map = new int[n][m];
      min = Integer.MAX_VALUE;
      vis = new boolean[n][m];
      
      //DP
      minArray = new int[n][m];
      for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
          minArray[i][j] = Integer.MAX_VALUE;
      
      for (int i = 0; i < n; i++) {
        String line = sc.nextLine();
        if (line.length() > 1) {
          String[] blockers = line.split(" ");
          for (int ti = 1; ti<blockers.length; ti++) {
            int nsb = Integer.parseInt(blockers[ti]); // north-south block
            map[i][nsb - 1] = 1;
          }
        }
      }
      //travel(0,0,0);
      fastTravel(0, 0, 0);
      int count = 0;
      for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
          if(minArray[i][j] == min){
            count++;
          }
        }
      }
      System.out.println(min);
      System.out.println(count);
    }
  }

}
