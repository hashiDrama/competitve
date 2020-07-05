package juniorSheet.cfA;

import java.util.Arrays;
import java.util.Scanner;

public class Twins {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int sum=0;
    for(int i=0; i<n; i++) {
      a[i] = sc.nextInt();
      sum += a[i];
    }
    int finalSum=0, count=0;
    Arrays.sort(a);
    for(int i=n-1; i>=0; i--) {
      finalSum += a[i];
      count++;
      if(finalSum > sum-finalSum) {
        break;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
