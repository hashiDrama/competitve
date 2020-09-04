package juniorSheet.cfB;

import java.math.BigInteger;
import java.util.Scanner;

public class BigMod {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      BigInteger b = new BigInteger(sc.next());
      BigInteger p = new BigInteger(sc.next());
      BigInteger m = new BigInteger(sc.next());

      System.out.println(b.modPow(p, m));
    }
    sc.close();
  }
}
