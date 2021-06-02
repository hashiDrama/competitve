/*
 * https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
 */
package interviewbit.array;

import java.util.ArrayList;
import java.util.Scanner;

public class TripletsWithSum {

  private static double add(String s1, String s2, String s3) {
    return Double.parseDouble(s1) + Double.parseDouble(s2) + Double.parseDouble(s3);
  }

  public static int solve(ArrayList<String> a) {
    int n = a.size();
    a.sort((s1, s2) -> {
      return Double.compare(Double.parseDouble(s1), Double.parseDouble(s2));
    });
    double sum = 0;
    int s = 0, e = n - 1, i = 1;
    while (e > s && e > i) {
      sum = add(a.get(s), a.get(i), a.get(e));
      if (sum > 1 && sum < 2)
        return 1;
      if (sum > 2)
        e--;
      if (sum < 1)
        i++;
      if (i == n - 1) {
        s++;
        i = s + 1;
        e = n - 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      list.add(sc.next());
    System.out.println(solve(list));
    sc.close();
  }
}
