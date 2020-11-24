package juniorSheet.cfB;

import java.math.BigInteger;
import java.util.Scanner;

public class Combinations {

  private static BigInteger factorial(int b) {
    BigInteger fact = BigInteger.ONE;
    for (int i = b; i > 0; i--) {
      fact = fact.multiply(BigInteger.valueOf(i));
    }
    return fact;
  }

  // c= (n!/((n-m)! * m!)
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      if (n == 0 && m == 0) {
        break;
      }

      BigInteger combinations = factorial(n).divide(factorial(n - m).multiply(factorial(m)));
      System.out.println(n + " things taken " + m + " at a time is " + combinations + " exactly.");
    }
    sc.close();
  }
}
