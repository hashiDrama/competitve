package cfLiveRounds.R661;

import static java.lang.Math.abs;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveSmallest {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      Arrays.sort(a);
      boolean possible = true;
      for (int i = 0; i < n - 1; i++) {
        if (abs(a[i] - a[i + 1]) > 1) {
          possible = false;
          break;
        }
      }
      if (!possible) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
    sc.close();
  }
}
