/*
 * https://www.codechef.com/START1C/problems/COUPON2
 */
package cchefLiveRounds.codechefStarters2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem1 {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      String[] data = reader.readLine().split(" ");

      int d = Integer.parseInt(data[0]);
      int c = Integer.parseInt(data[1]);
      int suma = 0, sumb = 0;

      data = reader.readLine().split(" ");
      int[] a = new int[3];
      for (int i = 0; i < 3; i++) {
        a[i] = Integer.parseInt(data[i]);
        suma += a[i];
      }
      data = reader.readLine().split(" ");
      int[] b = new int[3];
      for (int i = 0; i < 3; i++) {
        b[i] = Integer.parseInt(data[i]);
        sumb += b[i];
      }

      // logic
      String ans = "";
      if (suma < 150 && sumb < 150)
        ans = "NO";
      else if (suma >= 150 && sumb >= 150) {
        if (c < 2 * d)
          ans = "YES";
        else
          ans = "NO";
      } else {
        if (c < d)
          ans = "YES";
        else
          ans = "NO";
      }
      System.out.println(ans);
    }
  }
}
