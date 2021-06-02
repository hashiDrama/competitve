/*
 * https://www.codechef.com/FEB21C/problems/MAXFUN
 */
package cchefLiveRounds.febChallengeDiv3;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2 {

  private static int findSum(int[] a, int n) {
    int max = 0, sum;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          sum = abs(a[i] - a[j]) + abs(a[j] - a[k]) + abs(a[k] - a[i]);
          max = max(max, sum);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];
      line = br.readLine();
      String[] elem = line.split(" ");
      for (int i = 0; i < n; i++)
        a[i] = Integer.parseInt(elem[i]);
      Arrays.sort(a);
      int min = a[0];
      int max = a[n-1];
      System.out.println(2 * (max-min));
    }
  }
}
