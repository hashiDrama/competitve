package juniorSheet.cfA;

import java.util.Scanner;

public class LineLandMail {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0; i<n; i++) {
      a[i] = sc.nextInt();
    }
    int min, max;
    for(int i=0; i<n; i++) {
      max = Math.abs(a[i]-a[0]);
      max = Math.abs(a[i] - a[n-1]) > max ? Math.abs(a[i] - a[n-1]) : max;
      min = Integer.MAX_VALUE;
      if(i > 0) { min = Math.abs(a[i] - a[i-1]); }
      if(i < n-1) { min = Math.abs(a[i] - a[i+1]) < min ? Math.abs(a[i] - a[i+1]) : min; }
      System.out.println(min + " " + max);
    }
    sc.close();
  }
}
