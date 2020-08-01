package cfLiveRounds.R658;

import java.util.Scanner;

public class CommonSubsequence {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[m];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < m; i++) {
        b[i] = sc.nextInt();
      }
      boolean found = false;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (a[i] == b[j]) {
            System.out.println("YES");
            System.out.println(1 + " " + a[i]);
            found = true;
            break;
          }
        }
        if (found) {
          break;
        }
      }
      if (!found) {
        System.out.println("NO");
      }
    }
    sc.close();
  }
}
