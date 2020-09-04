package cchefLiveRounds.augustChallengeDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndLinearChess {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null || line.isEmpty()) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      String[] data = reader.readLine().split(" ");
      int n = Integer.parseInt(data[0]);
      int k = Integer.parseInt(data[1]);
      int[] a = new int[n];
      data = reader.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(data[i]);
      }
      int min = Integer.MAX_VALUE, temp = 0, minI = -1;
      for (int i = 0; i < n; i++) {
        if (k % a[i] == 0) {
          temp = k / a[i];
          if (min > temp) {
            min = temp;
            minI = i;
          }
        }
      }
      if (min == Integer.MAX_VALUE) {
        System.out.println(-1);
      } else {
        System.out.println(a[minI]);
      }
    }
    reader.close();
  }
}
