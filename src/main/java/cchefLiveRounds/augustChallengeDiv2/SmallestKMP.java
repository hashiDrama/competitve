package cchefLiveRounds.augustChallengeDiv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestKMP {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null || line.isEmpty()) {
      return;
    }
    StringBuilder ans = new StringBuilder(); 
    int T = Integer.parseInt(line);
    for (int t = 0; t < T; t++) {
      String s = reader.readLine();
      String p = reader.readLine();

      char[] cs = new char[128];
      char[] cp = new char[128];

      char[] sarr = s.toCharArray();
      char[] parr = p.toCharArray();
      for (int i = 0; i < 128; i++) {
        cs[i] = 0;
        cp[i] = 0;
      }
      for (int i = 0; i < s.length(); i++) {
        cs[sarr[i]]++;
      }
      for (int i = 0; i < p.length(); i++) {
        cp[parr[i]]++;
      }

      for (int i = 0; i < 128; i++) {
        cs[i] -= cp[i];
      }

      StringBuilder output = new StringBuilder();
      int i = 'a';
      while (i <= parr[0]) {
        while (cs[i] > 0) {
          output.append((char) i);
          cs[i]--;
        }
        i++;
      }
      output.append(p);
      while (i <= 'z') {
        while (cs[i] > 0) {
          output.append((char) i);
          cs[i]--;
        }
        i++;
      }
      if(t==T-1) {
        ans.append(output.toString());
      }else {
        ans.append(output.toString() + "\n"); 
      }
    }
    System.out.println(ans);
    reader.close();
  }
}
