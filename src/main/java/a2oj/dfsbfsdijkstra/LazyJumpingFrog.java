/*
 * Live archive - 3652; 
 * link -> https://icpcarchive.ecs.baylor.edu/index.php?option=onlinejudge&page=show_problem&problem=1653
 */
package a2oj.dfsbfsdijkstra;

import java.util.Scanner;

public class LazyJumpingFrog {

  private static int c,r, ans, tc, tr;
  private static int[][] marsh;
  private static boolean[][] vis;
  
  private static int[] di = new int[] {
      -2, -2, -2, -2 , -2, 
      -1, -1, -1, -1, -1,
      0, 0, 0, 0, 0,
      1, 1, 1, 1, 1,
      2, 2, 2, 2, 2};
  private static int[] dj = new int[] {
      -2, -1, 0, 1, 2,
      -2, -1, 0, 1, 2,
      -2, -1, 0, 1, 2,
      -2, -1, 0, 1, 2,
      -2, -1, 0, 1, 2
  };
  
  private static int[] cost = new int[] {
      7,6,5,6,7,
      6,3,2,3,6,
      5,2,0,2,5,
      6,3,2,3,6,
      7,6,5,6,7
  };
  
  private static boolean valid(int i, int j) {
    return i>=0 && i<r && j>=0 && j<c;
  }
  
  private static void dfs(int i, int j, int sum, int costi) {
    if(!valid(i, j) || vis[i][j] || marsh[i][j] == -1)
      return;
    if(i == tr && j == tc) {
      ans = Math.min(ans, sum);
      return;
    }
    vis[i][j] = true;
    sum += costi;
    for(int k=0; k<25; k++) {
      dfs(i + di[k], j + dj[k], sum, cost[k]);
    }
    vis[i][j] = false;
    //System.out.println("next");
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      c = sc.nextInt();
      r = sc.nextInt();
      if( c == 0 && r == 0)
        break;
      marsh = new int[r][c];
      vis = new boolean[r][c];
      int fc = sc.nextInt()-1;
      int fr = sc.nextInt()-1;
      tc = sc.nextInt()-1;
      tr = sc.nextInt()-1;
      
      int w = sc.nextInt();
      int c1,r1,c2,r2;
      for(int i=0; i<w; i++) {
        c1 = sc.nextInt();
        r1 = sc.nextInt();
        c2 = sc.nextInt();
        r2 = sc.nextInt();
        for(int j=r1-1; j<r2; j++) {
          for(int k=c1-1; k<c2; k++) {
            marsh[j][k] = -1;
          }
        }
      }
      ans = Integer.MAX_VALUE;
      dfs(fr, fc, 0, 0);
      if(ans == Integer.MAX_VALUE)
        System.out.println("impossible");
      else
        System.out.println(ans);
    }
    sc.close();
  }
}
