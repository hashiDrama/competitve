package cchefLiveRounds.julyCookoffDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EventualReduction {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(reader.readLine());
      String s = reader.readLine();
      char[] ch = new char[128];
      for (char c : s.toCharArray()) {
        ch[c]++;
      }
      boolean found = false;
      for (int i = 0; i < 128; i++) {
        if (ch[i] % 2 != 0) {
          System.out.println("NO");
          found = true;
          break;
        }
      }
      if (!found) {
        System.out.println("YES");
      }
    }
    reader.close();
  }
}
