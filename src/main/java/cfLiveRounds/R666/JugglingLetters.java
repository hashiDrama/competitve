package cfLiveRounds.R666;

import java.util.Scanner;

public class JugglingLetters {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      String[] s = new String[n];
      for (int i = 0; i < n; i++) {
        s[i] = sc.next();
      }
      int[] c = new int[128];
      for (String str : s) {
        for (char ch : str.toCharArray()) {
          c[ch]++;
        }
      }
      boolean res = true;
      for (int i = 0; i < c.length; i++) {
        if (c[i] % n != 0) {
          res = false;
        }
        if (!res) {
          break;
        }
      }
      System.out.println(res ? "YES" : "NO");
    }
    sc.close();
  }
}
