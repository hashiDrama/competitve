package juniorSheet.cfB;

import java.util.Arrays;
import java.util.Scanner;

public class VanyaAndLanterns {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int l = sc.nextInt();
    int[] a = new int[n];
    boolean f1 = false, f2 = false;
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      if (a[i] == 0)
        f1 = true;
      if (a[i] == l)
        f2 = true;
    }
    Arrays.sort(a);
    int mx = Integer.MIN_VALUE;
    for (int i = 1; i < n; i++) {
      mx = Math.max(mx, a[i] - a[i - 1]);
    }
    double ans = ((double) mx) / 2;
    if (!f1)
      ans = Math.max(ans, a[0]);
    if (!f2)
      ans = Math.max(ans, l - a[n - 1]);
    System.out.println(ans);
    sc.close();
  }
}
