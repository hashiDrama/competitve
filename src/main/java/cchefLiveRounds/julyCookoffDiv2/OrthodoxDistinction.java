package cchefLiveRounds.julyCookoffDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OrthodoxDistinction {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null) {
      return;
    }
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(reader.readLine());
      String[] s = reader.readLine().split(" ");
      long[] a = new long[n];
      int I = 0;
      for (String st : s) {
        a[I++] = Long.parseLong(st);
      }
      long temp = 0L;
      boolean found = false;
      List<Long> res = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          temp = 0L;
          for (int k = i; k <= j; k++) {
            temp |= a[k];
          }
          if (res.contains(temp)) {
            System.out.println("NO");
            found = true;
            break;
          }
          res.add(temp);
        }
        if (found) {
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
