package juniorSheet.cfA;

import java.math.BigInteger;
import java.util.Scanner;

public class TheatreSquare {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int a = sc.nextInt();
    int count = 0;
    if (a >= n && a >= m) {
      count = 1;
    } else if (a >= n && a < m) {
      if (m % a != 0) {
        count = (m / a) + 1;
      } else {
        count = (m / a);
      }
    } else if (a < n && a >= m) {
      if (n % a != 0) {
        count = (n / a) + 1;
      } else {
        count = (n / a);
      }
    } else {
      int count1, count2;
      if (m % a != 0) {
        count1 = ((m / a) + 1);
      } else {
        count1 = (m / a);
      }
      if (n % a != 0) {
        count2 = ((n / a) + 1);
      } else {
        count2 = (n / a);
      }
      BigInteger c1 = new BigInteger("" + count1);
      BigInteger c2 = new BigInteger("" + count2);
      System.out.println(c1.multiply(c2));
      return;
    }
    System.out.println(count);
    sc.close();
  }
}
