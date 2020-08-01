package cchefLiveRounds.julyLunchTimeDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GolombSequence {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null || line.isEmpty()) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      String[] data = br.readLine().split(" ");
      long l = Long.parseLong(data[0]);
      long r = Long.parseLong(data[1]);

      int mod = 1000000000 + 7;
      long sum = 0L;

      Map<Long, Long> map = new HashMap<>();
      map.put(1L, 1L);
      long temp;
      for (long i = 2; i <= r; i++) {
        temp = 1 + map.get(i - map.get(map.get(i - 1)));
        // a[i] = 1 + a[(int) i - (int) a[(int) a[i - 1]]];
        map.put(i, temp);
      }
      for (long i = l; i <= r; i++) {
        sum += map.get(i) * map.get(i);
      }
      System.out.println(sum % mod);
    }
    br.close();
  }
}
