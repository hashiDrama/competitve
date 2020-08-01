package cchefLiveRounds.julyLunchTimeDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumCandies {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null || line.isEmpty()) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      String[] data = br.readLine().split(" ");
      int n = Integer.parseInt(data[0]);
      int m = Integer.parseInt(data[1]);
      int x = Integer.parseInt(data[2]);
      int y = Integer.parseInt(data[3]);

      int cells = (n * m) / 2;
      if ((n * m) % 2 != 0) {
        cells++;
      }
      if (x >= y) {
        System.out.println(cells * y);
      } else {
        System.out.println(cells * x + (cells * (y - x)));
      }
    }
    br.close();
  }
}
