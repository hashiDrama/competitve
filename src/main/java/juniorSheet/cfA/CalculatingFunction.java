package juniorSheet.cfA;

import java.math.BigInteger;
import java.util.Scanner;

public class CalculatingFunction {

  public static void main(String[] args) {
    BigInteger num = new BigInteger(new Scanner(System.in).next());
    BigInteger two = new BigInteger("2");
    BigInteger minusOne = new BigInteger("-1");
    BigInteger one = new BigInteger("1");
    BigInteger zero = new BigInteger("0");
    System.out
        .println(num.mod(two).compareTo(zero) != 0 ? num.divide(two).add(one).multiply(minusOne)
            : num.divide(two));
  }
}
