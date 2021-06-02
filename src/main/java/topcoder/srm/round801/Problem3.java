/*
 * https://arena.topcoder.com/#/u/coding/18530/16825/2
 */
package topcoder.srm.round801;

import java.util.*;
import java.util.stream.Collectors;

public class Problem3 {

  private static double findSquare(int a, int b) {
    return Math.pow(a - b, 2);
  }

  private static double findDist(int i, int j, int[] x, int[] y) {
    return Math.sqrt(findSquare(x[i], x[j]) + findSquare(y[i], y[j]));
  }

  private static int[] solve(int[] a) {
    List<Integer> l = new ArrayList<>();
    return new ArrayList<Integer>().stream().mapToInt(Integer::intValue).toArray();
  }
  private static long getSecondDiameters(int[] x, int[] y) {
    List<Integer> l = new ArrayList<>();
    Arrays.stream(x).boxed().collect(Collectors.toList());
    int n = x.length;
    double ans = 0;
    for (int i = 0; i < n; i++) {
      Set<Double> d = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (i == j)
          continue;
        for (int k = 0; k < n; k++) {
          if (i == k)
            continue;
          d.add(findDist(j, k, x, y));
        }
      }
      List<Double> list = new ArrayList<>(d);
      list.sort(null);
      ans += list.get(1);
    }
    return (long)ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++)
      x[i] = sc.nextInt();
    for (int i = 0; i < n; i++)
      y[i] = sc.nextInt();
    System.out.println(getSecondDiameters(x, y));
    sc.close();
  }
}
