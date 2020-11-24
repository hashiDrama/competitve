/*
 * CFB round #277; link -> https://codeforces.com/contest/486/problem/B
 */

package juniorSheet.cfB;


import java.util.Scanner;

public class ORInMatrix {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] a = new int[n][m];
    int[][] b = new int[n][m];

    // initialize b and set all elements of a = 1
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++) {
        b[i][j] = sc.nextInt();
        a[i][j] = 1;
      }
    // create a from b
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (b[i][j] == 0) {
          for (int k = 0; k < n; k++) {
            a[k][j] = 0;
          }
          for (int k = 0; k < m; k++) {
            a[i][k] = 0;
          }
        }
      }
    }
    // check if b can be created from a
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (b[i][j] == 0) {
          for (int k = 0; k < n; k++) {
            if (a[k][j] == 1) {
              System.out.println("NO");
              return;
            }
          }
          for (int k = 0; k < m; k++) {
            if (a[i][k] == 1) {
              System.out.println("NO");
              return;
            }
          }
        } else {
          boolean found = false;
          for (int k = 0; k < n; k++) {
            if (a[k][j] == 1)
              found = true;
          }
          for (int k = 0; k < m; k++) {
            if (a[i][k] == 1)
              found = true;
          }
          if (!found) {
            System.out.println("NO");
            return;
          }
        }
      }
    }
    System.out.println("YES");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println("");
    }
    sc.close();
  }
}
