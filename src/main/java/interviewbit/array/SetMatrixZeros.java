/*
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 */
package interviewbit.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SetMatrixZeros {

  private static void solve(ArrayList<ArrayList<Integer>> a, int m, int n) {
    Map<Integer, Boolean> rz = new HashMap<>();
    Map<Integer, Boolean> cz = new HashMap<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < a.get(i).size(); j++) {
        if (a.get(i).get(j) == 0) {
          rz.put(i, true);
          cz.put(j, true);
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rz.containsKey(i) || cz.containsKey(j))
          a.get(i).set(j, 0);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        int num = sc.nextInt();
        list.add(num);
      }
      a.add(list);
    }
    solve(a, m, n);
    for (ArrayList<Integer> list : a) {
      list.forEach(l -> System.out.print(l + " "));
      System.out.println();
    }
    sc.close();
  }
}
