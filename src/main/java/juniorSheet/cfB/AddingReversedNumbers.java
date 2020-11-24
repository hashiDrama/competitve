package juniorSheet.cfB;

import java.math.BigInteger;
import java.util.Scanner;

public class AddingReversedNumbers {

  private static BigInteger reverse(String n) {
    StringBuilder s = new StringBuilder(n);
    return new BigInteger(s.reverse().toString());
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n-- > 0) {
      System.out.println(reverse(reverse(sc.next()).add(reverse(sc.next())).toString()));
    }
    sc.close();
  }
}
