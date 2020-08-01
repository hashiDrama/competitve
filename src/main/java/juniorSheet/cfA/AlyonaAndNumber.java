package juniorSheet.cfA;

import java.util.Scanner;

public class AlyonaAndNumber {

  // amazing solution
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();
    long m = sc.nextInt();
    long[] a = new long[5];
    long[] b = new long[5];
    for (int i = 1; i <= n; i++) {
      a[i % 5]++;
    }
    for (int i = 1; i <= m; i++) {
      b[i % 5]++;
    }

    System.out.println(a[0] * b[0] + a[1] * b[4] + a[2] * b[3] + a[3] * b[2] + a[4] * b[1]);
    sc.close();
  }

  // TLE for n=100,000 and m=100,000
  // public static void main(String[] args) {
  // Scanner sc = new Scanner(System.in);
  // int n = sc.nextInt();
  // int m = sc.nextInt();
  //
  // int count = 0;
  // for (int i = 1; i <= n; i++) {
  // for (int j = 1; j <= m; j++) {
  // if ((i + j) % 5 == 0) {
  // count++;
  // }
  // }
  // }
  // System.out.println(count);
  // sc.close();
  // }
}
