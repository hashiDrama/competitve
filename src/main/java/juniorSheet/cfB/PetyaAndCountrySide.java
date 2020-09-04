package juniorSheet.cfB;

import java.util.Scanner;

public class PetyaAndCountrySide {

  private static int getMaxWateredSections(int[] a, int n) {
    int max=0;
    int count;
    for(int i=0; i<n; i++) {
      count = 1;
      for(int j=i; j>0; j--) {
        if(a[j-1] > a[j]) {break;}
        count++;
      }
      for(int j=i; j<n-1; j++) {
        if(a[j+1] > a[j]) {break;}
        count++;
      }
      if(max < count) {
        max = count;
      }
    }
    return max;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i=0; i<n; i++) {
      a[i] = sc.nextInt();
    }
    System.out.println(getMaxWateredSections(a, n));
    sc.close();
  }
}
