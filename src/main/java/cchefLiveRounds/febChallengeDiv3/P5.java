/*
 * https://www.codechef.com/FEB21C/problems/TEAMNAME
 */
package cchefLiveRounds.febChallengeDiv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P5 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String[] s = br.readLine().split(" ");
      Set<String> names = Arrays.stream(s).collect(Collectors.toSet());
      int count = 0;
      String s1, s2;
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          s1 = "" + s[i].charAt(0) + s[j].substring(1);
          s2 = "" + s[j].charAt(0) + s[i].substring(1);
          if (!names.contains(s1) && !names.contains(s2))
            count += 2;
        }
      }
      System.out.println(count);
    }
  }
}
