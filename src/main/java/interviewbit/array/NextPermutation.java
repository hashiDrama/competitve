/*
 * https://www.interviewbit.com/problems/next-permutation/
 */
package interviewbit.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NextPermutation {

  public static ArrayList<Integer> nextPermutation(ArrayList<Integer> a) {
    int n = a.size();
    int i = n - 1;
    boolean found = false;
    for (; i > 0; i--) {
      if (a.get(i) > a.get(i - 1)) {
        found = true;
        break;
      }
    }
    if (!found) {
      Collections.reverse(a);
      return a;
    }
    // find the smallest elem which is greater than i-1th elem
    int p = i - 1, q = i;
    for (; i < n; i++) {
      if (a.get(i) > a.get(p) && a.get(i) < a.get(q))
        q = i;
    }
    swap(p, q, a);
    List<Integer> subList = a.subList(p + 1, n);
    subList.sort(null);
    return a;
  }

  private static void swap(int i, int j, ArrayList<Integer> a) {
    int temp = a.get(i);
    a.set(i, a.get(j));
    a.set(j, temp);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    for (int i = 0; i < n; i++)
      a.add(sc.nextInt());
    nextPermutation(a);
    a.forEach(System.out::println);
  }
}
