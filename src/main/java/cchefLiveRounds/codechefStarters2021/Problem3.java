/*
 * https://www.codechef.com/START1C/problems/MVALUE
 */
package cchefLiveRounds.codechefStarters2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem3 {

  private static long solve(int a, int b) {
    return (a * b) + (a - b);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int n = Integer.parseInt(reader.readLine().trim());
      int[] a = new int[n];
      String[] data = reader.readLine().trim().split(" ");
      for (int i = 0; i < n; i++)
        a[i] = Integer.parseInt(data[i]);
      long max = Integer.MIN_VALUE;
      Arrays.sort(a);
      for (int i = 0; i < n - 1; i++) {
        max = Math.max(max, solve(a[n - 1], a[i]));
      }
      System.out.println(max);
    }
  }

}
