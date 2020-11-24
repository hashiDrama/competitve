package juniorSheet.cfB;

import java.util.Scanner;

public class Fence {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    a[0] = sc.nextInt();
    for (int i = 1; i < n; i++) {
      a[i] = sc.nextInt();
      a[i] += a[i - 1];
    }
    int min = Integer.MAX_VALUE, temp, idx = -1;
    for (int i = 0; i <= n - k; i++) {
      temp = i == 0 ? a[i + k - 1] : a[i + k - 1] - a[i - 1];
      if (min > temp) {
        min = temp;
        idx = i;
      }
    }
    System.out.println(idx+1);
    sc.close();
  }
}
