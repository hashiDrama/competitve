package juniorSheet.cfA;

import java.math.BigInteger;
import java.util.Scanner;

public class OlesyaAndRodion {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    BigInteger t = new BigInteger("" + sc.nextInt());
    BigInteger ten = new BigInteger("10");
    BigInteger one = new BigInteger("1");
    BigInteger zero = new BigInteger("0");
    BigInteger min = ten.pow(n - 1);
    BigInteger max = ten.pow(n);

    boolean found = false;
    BigInteger i = min;
    while (i.compareTo(max) < 0) {
      if (i.mod(t).equals(zero)) {
        System.out.println(i);
        found = true;
        break;
      }
      i = i.add(one);
    }
    if (!found) {
      System.out.println(-1);
    }
    sc.close();
  }
}
