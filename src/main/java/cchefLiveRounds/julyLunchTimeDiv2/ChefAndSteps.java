package cchefLiveRounds.julyLunchTimeDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndSteps {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null || line.isEmpty()) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      String[] data = br.readLine().split(" ");
      int N = Integer.parseInt(data[0]);
      int K = Integer.parseInt(data[1]);
      StringBuilder res = new StringBuilder();
      String[] all = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
        int a = Integer.parseInt(all[i]);
        if (a % K == 0) {
          res.append(1);
        } else {
          res.append(0);
        }
      }
      System.out.println(res.toString());
    }
    br.close();
  }
}
