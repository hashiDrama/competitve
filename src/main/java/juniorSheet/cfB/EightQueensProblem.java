package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EightQueensProblem {

  static int n, r, c;
  static List<List<Integer>> result;

  private static boolean isValid(List<Integer> colsList) {
    int rowId = colsList.size() - 1;
    int diff;
    for (int i = 0; i < colsList.size() - 1; i++) {
      diff = Math.abs(colsList.get(i) - colsList.get(rowId));
      if (diff == 0 || diff == (rowId - i))
        return false;
    }
    return true;
  }

  private static void solveNQProblem(int n, int row, List<Integer> colsList) {
    if (row == n) {
      result.add(new ArrayList<>(colsList));
      return;
    }
    for (int i = 0; i < n; i++) {
      colsList.add(i);
      if (isValid(colsList)) {
        solveNQProblem(n, row + 1, colsList);
      }
      colsList.remove(colsList.size() - 1);
    }
  }

  private static void print() {
    System.out.println("SOLN       COLUMN");
    System.out.println(" #      1 2 3 4 5 6 7 8");
    System.out.println();

    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).get(0) != c)
        continue;
      System.out.print(" " + (i + 1) + "     ");
      for (int j = 0; j < result.get(i).size(); j++) {
        System.out.print(" " + (result.get(i).get(j) + 1));
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    n = 8;
    while (T-- > 0) {
      r = sc.nextInt();
      c = sc.nextInt();
      r--;
      c--;
      List<Integer> colsList = new ArrayList();
      // colsList.add(c);
      result = new ArrayList();
      solveNQProblem(n, r, colsList);
      print();
    }
  }
}
