package juniorSheet.cfA;

import java.math.BigInteger;
import java.util.Scanner;

public class EvenOdds {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    String[] data = line.split(" ");
    BigInteger n = new BigInteger(data[0]);
    BigInteger k = new BigInteger(data[1]);
    BigInteger two = new BigInteger("2");
    BigInteger zero = new BigInteger("0");
    BigInteger one = new BigInteger("1");

    if (n.mod(two).equals(zero)) {
      if (k.compareTo(n.divide(two)) <= 0) {
        System.out.println(k.multiply(two).subtract(one).toString());
      } else {
        System.out.println(k.multiply(two).subtract(n).toString());
      }
    } else {
      if (k.compareTo(n.divide(two).add(one)) <= 0) {
        System.out.println(k.multiply(two).subtract(one).toString());
      } else {
        System.out.println(k.multiply(two).subtract(n).subtract(one).toString());
      }
    }
    sc.close();
  }
}
