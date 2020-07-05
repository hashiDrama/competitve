package juniorSheet.cfA;

import java.util.Arrays;
import java.util.Scanner;

public class OathNightsWatch {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int[] a = new int[n];
    for(int i=0; i<n ;i++) {
      a[i] = sc.nextInt();
    }
    Arrays.sort(a);
    int count=0;
    for(int i=1; i<n-1; i++) {
      if(a[i] > a[0] && a[i] < a[n-1]) {
        count++;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
