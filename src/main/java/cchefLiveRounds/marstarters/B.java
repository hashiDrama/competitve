/*
 * https://www.codechef.com/START2C/problems/NOBEL
 */
package cchefLiveRounds.marstarters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B {

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
      int[] a = new int[n];
      data = reader.readLine().split(" ");
      Map<Integer, Boolean> map = new HashMap<>();
      for (int i = 0; i < n; i++)
        map.putIfAbsent(Integer.parseInt(data[i]), true);
      int ans = -1;
      for (int i = 1; i <= m; i++) {
        if (!map.containsKey(i)) {
          ans = i;
        }
      }
      if (ans == -1)
        System.out.println("No");
      else
        System.out.println("Yes");
    }
  }
}
