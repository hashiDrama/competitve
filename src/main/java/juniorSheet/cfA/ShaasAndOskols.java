package juniorSheet.cfA;

import java.util.Scanner;

public class ShaasAndOskols {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0; i<n; i++) {
      a[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    for(int i=0; i<m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if(x > 1) {
        a[x-2] += y-1;
      }
      if(x < a.length) {
        a[x] += a[x-1]-y;
      }
      a[x-1] = 0;
    }
    for(int i : a) {
      System.out.println(i);
    }
    sc.close();
  }
}
