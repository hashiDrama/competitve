package cfLiveRounds.R661;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import java.util.Scanner;

public class GiftsFixing {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
      }
      int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if (a[i] < minA) {
          minA = a[i];
        }
      }
      for (int i = 0; i < n; i++) {
        if (b[i] < minB) {
          minB = b[i];
        }
      }
      long count = 0L;
      for (int i = 0; i < n; i++) {
        if (a[i] != minA && b[i] != minB) {
          count += max(abs(a[i] - minA), abs(b[i] - minB));
          a[i] = minA;
          b[i] = minB;
        }
        if (b[i] != minB) {
          count += abs(b[i] - minB);
          b[i] = minB;
        }
        if (a[i] != minA) {
          count += abs(a[i] - minA);
          a[i] = minA;
        }
      }
      System.out.println(count);
    }
    sc.close();
  }
}
