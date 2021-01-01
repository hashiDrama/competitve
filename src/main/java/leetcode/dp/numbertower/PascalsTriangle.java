/*
 * Leetcode - Pascal's triangle;
 * link -> https://leetcode.com/problems/pascals-triangle/
 */
package leetcode.dp.numbertower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {

  public static List<List<Integer>> generate(int n) {
    List<List<Integer>> triangle = new ArrayList<>();
    if (n == 0)
      return triangle;
    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);
    for (int i = 1; i < n; i++) {
      List<Integer> pRow = triangle.get(i - 1);
      List<Integer> row = new ArrayList<>();
      row.add(1);
      for (int j = 1; j < i; j++)
        row.add(pRow.get(j - 1) + pRow.get(j));
      row.add(1);
      triangle.add(row);
    }

    return triangle;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<List<Integer>> ans = generate(n);
    int j;
    for (int i = 0; i < n; i++) {
      System.out.print("[");
      for (j = 0; j < i; j++) {
        System.out.print(ans.get(i).get(j) + ",");
      }
      if (i != n - 1)
        System.out.println(ans.get(i).get(j) + "],");
      else
        System.out.println(ans.get(i).get(j) + "]");
    }
    sc.close();
  }
}
