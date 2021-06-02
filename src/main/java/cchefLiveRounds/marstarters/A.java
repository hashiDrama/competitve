/*
 * https://www.codechef.com/START2C/problems/T20MCH
 */
package cchefLiveRounds.marstarters;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    if (line == null || line.isEmpty())
      return;
    String[] data = line.split(" ");
    int r = Integer.parseInt(data[0]);
    int o = Integer.parseInt(data[1]);
    int c = Integer.parseInt(data[2]);
    System.out.println(36 * (20 - o) > (r - c) ? "YES" : "No");
  }
}
