package juniorSheet.cfA;

import java.util.Scanner;

public class BearAndBigBrother {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int years = 0;
    while(a <= b) {
      a *= 3;
      b *= 2;
      years++;
    }
    System.out.println(years);
    sc.close();
  }
}
