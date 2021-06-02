/*
 * https://www.codechef.com/FEB21C/problems/MEET
 */
package cchefLiveRounds.febChallengeDiv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P3 {

  private static final String ampm[] = new String[] {"AM", "PM"};

  private static int getMinutes(String time, String ampmStr) {
    int min = 0; // 12:00 AM
    String[] timeArr = time.split(":");
    if (ampm[0].equals(ampmStr)) { // AM
      if (!"12".equals(timeArr[0]))
        min = Integer.parseInt(timeArr[0]) * 60;
    } else { // PM
      if (!"12".equals(timeArr[0]))
        min = (Integer.parseInt(timeArr[0]) + 12) * 60;
      else
        min = 12 * 60;
    }
    return min + Integer.parseInt(timeArr[1]);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      String[] timeStr = br.readLine().split(" ");
      int time = getMinutes(timeStr[0], timeStr[1]);

      int n = Integer.parseInt(br.readLine());
      int[] l = new int[n];
      int[] r = new int[n];
      String[] data;
      for (int i = 0; i < n; i++) {
        line = br.readLine();
        data = line.split(" ");
        l[i] = getMinutes(data[0], data[1]);
        r[i] = getMinutes(data[2], data[3]);
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (time >= l[i] && time <= r[i])
          sb.append(1);
        else
          sb.append(0);
      }
      System.out.println(sb.toString());
    }
  }
}
