/*
 * https://codeforces.com/contest/259/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class LittleElephantAndMagicSquare {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] a = new int[3][3];
    for(int i=0; i<3; i++)
      for(int j=0; j<3; j++)
        a[i][j] = sc.nextInt();
    int x=0, y=0, z=0;
    x = y + a[1][0] + a[1][2] - (a[0][1] + a[0][2]);
    x = y + a[0][1] + a[2][1] - (a[1][0] + a[2][0]);
  }
}
