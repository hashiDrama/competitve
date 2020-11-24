package juniorSheet.cfB;

import java.util.Scanner;

public class GiocoDellUVA260 {

  static char[][] board;
  static boolean[][] vis;
  static int n;
  static boolean found;

  static boolean valid(int i, int j) {
    return i >= 0 && j >= 0 && i < n && j < n;
  }

  static void check(int i, int j) {
    if (!valid(i, j) || vis[i][j] || (board[i][j] != 'b'))
      return;
    if (i == n - 1) {
      found = true;
      return;
    }
    vis[i][j] = true;
    check(i - 1, j - 1);
    check(i - 1, j);
    check(i, j - 1);
    check(i, j + 1);
    check(i + 1, j);
    check(i + 1, j + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = 1;
    while (true) {
      n = sc.nextInt();
      if (n == 0)
        break;
      board = new char[n][n];
      int bs = -1, ws = -1;
      for (int i = 0; i < n; i++) {
        String line = sc.next();
        int j = 0;
        for (char c : line.toCharArray()) {
          board[i][j] = c;
          if (bs == -1 && board[i][j] == 'b')
            bs = j;
          if (ws == -1 && board[i][j] == 'w')
            ws = i;
          j++;
        }
      }
      vis = new boolean[n][n];
      found = false;
      check(0, bs);
      System.out.println(cases + " " + (found ? 'B' : 'W'));
      cases++;
    }
    sc.close();
  }
}
