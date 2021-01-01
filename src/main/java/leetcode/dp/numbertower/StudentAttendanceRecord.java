/*
 * Leetcode-Student Attendance Record II; link ->
 * https://leetcode.com/problems/student-attendance-record-ii/
 */
package leetcode.dp.numbertower;

import java.util.Scanner;

public class StudentAttendanceRecord {

  private static final int mod = (int) 1e9 + 7;

  public static int checkRecord(int n) {
    if(n==1)return 3;
    int[] a = new int[n + 1];
    int[] p = new int[n + 1];
    int[] l = new int[n + 1];
    a[0] = 1;
    p[0] = 1;
    l[0] = 1;
    a[1] = 2;
    l[1] = 3;
    a[2] = 4;

    for (int i = 1; i < n; i++) {
      p[i] = ((a[i - 1] + l[i - 1]) % mod + p[i - 1]) % mod;
      if (i > 1)
        l[i] = ((a[i - 1] + p[i - 1]) % mod + (a[i - 2] + p[i - 2]) % mod) % mod;
      if (i > 2)
        a[i] = ((a[i - 1] + a[i - 2]) % mod + a[i - 3]) % mod;
    }
    return ((a[n - 1] % mod + p[n - 1] % mod) % mod + l[n - 1]) % mod;
  }

  private static int helper(int n, int totalA, int continuousL, Integer[][][] cache) {
    if (n == 0)
      return 1;
    if (cache[n][totalA][continuousL] != null)
      return cache[n][totalA][continuousL];

    int result = 0;
    if (totalA == 0) {
      result += helper(n - 1, totalA + 1, 0, cache); // Choose 'A'
      result %= mod;
    }

    if (continuousL < 2) {
      result += helper(n - 1, totalA, continuousL + 1, cache); // Choose 'L'
      result %= mod;
    }

    result += helper(n - 1, totalA, 0, cache); // Choose 'P'
    result %= mod;
    cache[n][totalA][continuousL] = result;
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ans = checkRecord(n);
    System.out.println(ans);
    sc.close();
  }
}
