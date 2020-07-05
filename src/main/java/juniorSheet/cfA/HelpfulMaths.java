package juniorSheet.cfA;

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] sum = sc.next().split("\\+");
    int[] a = new int[sum.length];
    int i=0;
    for(String s: sum) {
      a[i] = Integer.parseInt(s);
      i++;
    }
    Arrays.sort(a);
    for(int j=0; j<a.length-1; j++) {
      System.out.print(a[j] + "+");
    }
    System.out.println(a[a.length-1]);
    sc.close();
  }
}
