package cchefLiveRounds.augustChallengeDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefWars {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null || line.isEmpty()) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      String data = reader.readLine();
      int H = Integer.parseInt(data.split(" ")[0]);
      int temp = Integer.parseInt(data.split(" ")[1]);

      boolean chefWin = true;
      while (temp > 0 && H > 0) {
        H -= temp;
        temp /= 2;

        if (temp <= 0 && H > 0) {
          chefWin = false;
        }
      }
      System.out.println(chefWin ? 1 : 0);
    }
    reader.close();
  }
}
