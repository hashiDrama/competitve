package juniorSheet.cfB;

import java.util.Scanner;

public class KingsPath {
  
  private static final int MAX = Integer.MAX_VALUE;
  private static boolean[][] allowed, vis;
  private static int min, x1, y1;
  private static int[] di = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
  private static int[] dj = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
  
  private static boolean valid(int i, int j) {
    return i >= 0 && j >= 0;
  }
  
  private static void bfs(int i, int j, int count){
    if(!valid(i, j) || !allowed[i][j] || vis[i][j])
      return;
    if(i == x1 && j == y1) {
      min = Math.min(min, count);
      return;
    }
    vis[i][j] = true;
    count++;
    for(int t=0; t<8; t++) {
      int ni = i + di[t];
      int nj = j + dj[t];
      bfs(ni, nj, count);
    }
    vis[i][j] = false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x0 = sc.nextInt();
    int y0 = sc.nextInt();
    x1 = sc.nextInt();
    y1 = sc.nextInt();
    int n = sc.nextInt();
    allowed = new boolean[MAX][MAX];
    int r, c1,c2;
    for(int i=0; i<n; i++) {
      r = sc.nextInt();
      c1 = sc.nextInt();
      c2 = sc.nextInt();
      allowed[r-1][c1-1] = true;
      allowed[r-1][c2-1] = true;
    }
    vis = new boolean[MAX][MAX];
    min = MAX;
    bfs(x0,y0,0);
    if(min == MAX)
      min = -1;
    System.out.println(min);
    sc.close();
  }
}
