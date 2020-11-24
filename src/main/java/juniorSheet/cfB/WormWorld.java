/*
 * Link -> https://onlinejudge.org/external/8/838.pdf
 * 
 * The WormWold puzzle was initially proposed by Cliff Pickover in the Discover Magazine, issue of
 * November 1994 (a visit to his home page is highly recommended!). The WormWorld is a grid of
 * numbers and it is a tough place to live in. The worms that inhabit it are all born with nasty
 * allergies. The first time they come in contact with a number, their immune systems are
 * overstimulated; if they are exposed to that number a second time, they die of anaphylactic shock.
 * A worm can start crawling on any square in WormWorld, and it can then move horizontally or
 * vertically but not diagonally. In this scenario, what is the longest path a worm can take without
 * dying? An example is illustrated in the following figure. Write a program that determines the
 * largest path a worm can take for a given grid.
 * 
 * 
 * 
 * 
 * 
 */

package juniorSheet.cfB;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WormWorld {

  private static boolean vis[][];
  private static int loc[][];
  static int max = Integer.MIN_VALUE;
  static int n;
  static Set<Integer> nums;
  
  private static boolean isValid(int r, int c) {
    return r>=0 && c>= 0 && r<n && c<n;
  }
  
  private static void walk(int r, int c, int count) {
    if(!isValid(r, c) || vis[r][c] || nums.contains(loc[r][c]))
      return;
    vis[r][c]=true;
    nums.add(loc[r][c]);
    count++;
    walk(r-1, c, count);   //UP
    walk(r, c+1, count);   //RIGHT
    walk(r+1, c, count);   //BOTTOM
    walk(r, c-1, count);   //DOWN
    vis[r][c] = false;
    nums.remove(loc[r][c]);
    max = max > count ? max : count;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    sc.nextLine();
    while(T-- > 0){
      n = sc.nextInt();
      loc = new int[n][n];
      vis = new boolean[n][n];
      nums = new HashSet<Integer>();
      for(int i=0; i<n; i++)
        for(int j=0; j<n; j++)
          vis[i][j] = false;
      for(int i=0; i<n; i++) 
        for(int j=0; j<n; j++)
          loc[i][j] = sc.nextInt();
      int count = 0;
      //System.out.println(System.currentTimeMillis());
      walk(0,0, count);
      //System.out.println(System.currentTimeMillis());
      System.out.println(max);
      System.out.println();
    }
    sc.close();
  }
}
