package juniorSheet.cfB;

import java.util.Arrays;
import java.util.Scanner;

public class OlympicMedal {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n, m, k, A, B;

    // storing input
    n = sc.nextInt();
    int[] ar1 = new int[n];
    for (int i = 0; i < n; i++) {
      ar1[i] = sc.nextInt();
    }
    m = sc.nextInt();
    int[] ap1 = new int[m];
    for (int i = 0; i < m; i++) {
      ap1[i] = sc.nextInt();
    }
    k = sc.nextInt();
    int[] ap2 = new int[k];
    for (int i = 0; i < k; i++) {
      ap2[i] = sc.nextInt();
    }
    A = sc.nextInt();
    B = sc.nextInt();

    // logic from here
    Arrays.sort(ar1);
    int r1 = ar1[n - 1];
    Arrays.sort(ap1);
    int p1 = ap1[m - 1];
    double r2, max = Double.MIN_VALUE;
    int p2;
    for (int i = 0; i < k; i++) {
      p2 = ap2[i];
      r2 = ((double)r1) / Math.sqrt((((double)A/B) * ((double)p2/p1) +  1));
      max = Math.max(max, r2);
    }
    System.out.printf("%.12f", max);
    sc.close();
  }
}
