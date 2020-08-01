package juniorSheet.cfA;

import java.util.Scanner;
import static java.lang.Math.min;

public class LaunchOfCollider {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s = sc.next();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == 'R' && s.charAt(i + 1) == 'L') {
        ans = min(ans, (a[i + 1] - a[i]) / 2);
      }
    }
    if (ans == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(ans);
    }
    sc.close();
  }
}
