/*
 * https://www.codechef.com/FEB21C/problems/HDIVISR
 */
package cchefLiveRounds.febChallengeDiv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null)
      return;
    int n = Integer.parseInt(line);
    int i = 0;
    for (i = 10; i >= 1; i--)
      if (n % i == 0)
        break;
    System.out.println(i);
  }
}
