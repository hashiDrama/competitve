package juniorSheet.cfB;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PresidentsOffice {

  static void checkAdjacent(char[][] c, int i, int j, int n, int m, Set<Character> deputiesSet,
      char pColor) {
    if (i > 0 && c[i - 1][j] != pColor && c[i - 1][j] != '.')
      deputiesSet.add(c[i - 1][j]);
    if (i < n - 1 && c[i + 1][j] != pColor && c[i + 1][j] != '.')
      deputiesSet.add(c[i + 1][j]);
    if (j > 0 && c[i][j - 1] != pColor && c[i][j - 1] != '.')
      deputiesSet.add(c[i][j - 1]);
    if (j < m - 1 && c[i][j + 1] != pColor && c[i][j + 1] != '.')
      deputiesSet.add(c[i][j + 1]);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    char pColor = sc.next().charAt(0);
    char[][] c = new char[n][m];
    for (int i = 0; i < n; i++) {
      c[i] = sc.next().toCharArray();
    }
    Set<Character> deputiesSet = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (c[i][j] == pColor) {
          checkAdjacent(c, i, j, n, m, deputiesSet, pColor);
        }
      }
    }
    System.out.println(deputiesSet.size());
    sc.close();
  }
}
