package cfLiveRounds.ECR91;

import java.util.Scanner;

public class ThreeIndices {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] p = new int[n];
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        p[i] = sc.nextInt();
        a[p[i] - 1] = i;
      }
      boolean found = false;
      for (int i = 0; i < n; i++) {
        if (a[n - 1 - i] > 0 && a[n - 1 - i] < n - 1) {
          if ((p[a[n - 1 - i] - 1] < p[a[n - 1 - i]]) && (p[a[n - 1 - i] + 1] < p[a[n - 1 - i]])) {
            System.out.println("YES");
            System.out.println(a[n - 1 - i] + " " + (a[n - 1 - i] + 1) + " " + (a[n - 1 - i] + 2));
            found = true;
            break;
          }
        }
      }
      if (!found) {
        System.out.println("NO");
      }
    }
    sc.close();
  }
}
