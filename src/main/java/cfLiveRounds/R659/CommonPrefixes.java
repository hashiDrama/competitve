package cfLiveRounds.R659;

import java.util.Scanner;
import static java.lang.Math.max;

public class CommonPrefixes {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }

      StringBuilder[] s = new StringBuilder[n + 1];
      for(int i=0; i<n+1; i++) {
        s[i] = new StringBuilder();
      }
      char[] c = new char[128];
      for (int i = 0; i < 128; i++) {
        c[i] = (char) i;
      }
      for (int i = 0; i < a[0]; i++) {
        s[0].append(c['a' + i]);
      }
      for (int i = 1; i < n; i++) {
        for (int j = 0; j < max(a[i - 1], a[i]); j++) {
          s[i].append(c['a' + j]);
        }
      }
      for (int i = 0; i < a[n - 1]; i++) {
        s[n].append(c['a' + i]);
      }
      for (StringBuilder sb : s) {
        System.out.println(sb.toString());
      }
    }
    sc.close();
  }
}
