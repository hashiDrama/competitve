/*
 * https://www.codechef.com/START1C/problems/COLGLF2
 */
package cchefLiveRounds.codechefStarters2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Problem2 {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int s = Integer.parseInt(reader.readLine());
      int[] q = new int[s];
      String[] data = reader.readLine().split(" ");
      for (int i = 0; i < s; i++)
        q[i] = Integer.parseInt(data[i]);
      long time = 0;
      for (int i = 0; i < s; i++) {
        data = reader.readLine().split(" ");
        time += Integer.parseInt(data[1]);
        for (int j = 2; j < data.length; j++) {
          time += Integer.parseInt(data[j]) - q[i];
        }
      }
      System.out.println(time);
    }
  }
}
