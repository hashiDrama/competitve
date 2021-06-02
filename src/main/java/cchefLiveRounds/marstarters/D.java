/*
 * https://www.codechef.com/START2C/problems/COLGLF5
 */
package cchefLiveRounds.marstarters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null || line.isEmpty())
      return;
    int t = Integer.parseInt(line);
    String[] data;
    while (t-- > 0) {
      data = reader.readLine().split(" ");
      int n = Integer.parseInt(data[0]);
      int m = Integer.parseInt(data[1]);
      int[] f = new int[n], c = new int[m];
      data = reader.readLine().split(" ");
      for (int i = 0; i < n; i++)
        f[i] = Integer.parseInt(data[i]);
      data = reader.readLine().split(" ");
      for (int i = 0; i < m; i++)
        c[i] = Integer.parseInt(data[i]);
      int i = 0, j = 0, ans = 0;
      Arrays.sort(f);
      Arrays.sort(c);
      char event = 'F'; // 'C' || 'F'
      while (i < n && j < m) {
        if (event == 'F') {
          if (f[i] > c[j]) {
            ans++;
            event = 'C';
            j++;
          } else {
            i++;
          }
        } else if (event == 'C') {
          if (c[j] > f[i]) {
            ans++;
            event = 'F';
            i++;
          } else {
            j++;
          }
        }
      }
      if (event != 'F' && i != n) {
        ans++;
      }
      if (event != 'C' && j != m) {
        ans++;
      }
      System.out.println(ans);
    }
  }
}

