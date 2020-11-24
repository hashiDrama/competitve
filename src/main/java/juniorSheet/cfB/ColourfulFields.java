package juniorSheet.cfB;

import java.util.Scanner;

public class ColourfulFields {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int t = sc.nextInt();
    char[][] c = new char[n][m];
    char[] veg = new char[] {'c', 'k', 'g'};
    int v = 0;
    for (int i = 0; i < k; i++) {
      c[sc.nextInt() - 1][sc.nextInt() - 1] = 'w';
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (c[i][j] != 'w') {
          c[i][j] = veg[v];
          v++;
          if (v == 3)
            v = 0;
        }
      }
    }
    int rw, col;
    for (int i = 0; i < t; i++) {
      rw = sc.nextInt();
      col = sc.nextInt();
      switch (c[rw - 1][col - 1]) {
        case 'w':
          System.out.println("Waste");
          break;
        case 'c':
          System.out.println("Carrots");
          break;
        case 'k':
          System.out.println("Kiwis");
          break;
        case 'g':
          System.out.println("Grapes");
          break;
        default:
          break;
      }
    }
    sc.close();
  }
}
