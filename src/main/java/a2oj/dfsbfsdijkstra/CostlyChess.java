/*
 * SPOJ-Costly Chess; link -> https://www.spoj.com/problems/CCHESS/
 */
package a2oj.dfsbfsdijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CostlyChess {

  private static final int inf = Integer.MAX_VALUE;

  private static boolean[][] vis;
  private static int[][] d;

  private static int[] di = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
  private static int[] dj = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};

  private static boolean valid(int i, int j) {
    return i >= 0 && i < 8 && j >= 0 && j < 8;
  }

  private static int bfs(int si, int sj, int desti, int destj) {
    PriorityQueue<Pair> q = new PriorityQueue<>();
    for(int i=0; i<8; i++)
      Arrays.fill(d[i], inf);
    d[si][sj] = 0;
    q.add(new Pair(si, sj, 0));
    Pair top;
    int ni, nj, temp;
    while(!q.isEmpty()) {
      top = q.poll();
      if(vis[top.i][top.j])
        continue;
      if(top.i == desti && top.j == destj)
        return top.w;
      vis[top.i][top.j] = true;
      for(int t=0; t<8; t++) {
        ni = top.i + di[t];
        nj = top.j + dj[t];
        if(valid(ni, nj)) {
          temp = top.w + top.i * ni + top.j * nj;
          q.add(new Pair(ni, nj, temp));
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int srci = sc.nextInt();
      int srcj = sc.nextInt();
      int desti = sc.nextInt();
      int destj = sc.nextInt();
      vis = new boolean[8][8];
      d = new int[8][8];
      int resp = bfs(srci, srcj, desti, destj);
      System.out.println(resp);
//      if (d[desti][destj] == inf)
//        System.out.println(-1);
//      else
//        System.out.println(d[desti][destj]);
    }
    sc.close();
  }

  private static class Pair implements Comparable<Pair>{
    int i,j,w;
    
    public Pair(int i, int j, int w){
      this.i= i;
      this.j = j;
      this.w = w;
    }
    
    @Override
    public int compareTo(Pair p) {
      return this.w < p.w ? -1 :
        this.w > p.w ? 1 : 0;
    }
  }
}
