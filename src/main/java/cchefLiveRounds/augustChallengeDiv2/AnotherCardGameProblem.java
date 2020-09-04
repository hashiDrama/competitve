package cchefLiveRounds.augustChallengeDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnotherCardGameProblem {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null || line.isEmpty()) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      String[] data = reader.readLine().split(" ");
      int pc = Integer.parseInt(data[0]);
      int pr = Integer.parseInt(data[1]);

      int countc = pc / 9;
      int countr = pr / 9;

      if(countc == 0 || pc%9 != 0) {
        countc++;
      }
      if(countr ==0 || pr%9 != 0) {
        countr++;
      }
      if (countc < countr) {
        System.out.println(0 + " " + countc);
      } else {
        System.out.println(1 + " " + countr);
      }
    }
    reader.close();
  }
}
