/*
 * Leetcode - Pascal's triangle 2; link-> https://leetcode.com/problems/pascals-triangle-ii/
 */
package leetcode.dp.numbertower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle2 {

  public static List<Integer> getRow(int ri) {
    List<Integer> row, prow;
    prow = new ArrayList<>();
    prow.add(1);
    for (int i = 1; i <= ri; i++) {
      row = new ArrayList<>();
      row.add(1);
      for (int j = 1; j < i; j++)
        row.add(prow.get(j - 1) + prow.get(j));
      row.add(1);
      prow.clear();
      prow.addAll(row);
    }
    return prow;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int ri = sc.nextInt();
    List<Integer> ans = getRow(ri);
    int i;
    System.out.print("[");
    for (i = 0; i < ans.size() - 1; i++) {
      System.out.print(ans.get(i) + ",");
    }
    System.out.println(ans.get(i) + "]");
    sc.close();
  }
}
