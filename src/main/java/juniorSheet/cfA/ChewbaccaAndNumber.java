package juniorSheet.cfA;

import java.util.Scanner;

public class ChewbaccaAndNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long x = sc.nextLong();
    char[] digits = Long.toString(x).toCharArray();
    StringBuilder sb = new StringBuilder();
    int v = Character.getNumericValue(digits[0]);
    sb.append(9 - v != 0 && 9 - v < v ? 9 - v : v);
    for (int i = 1; i < digits.length; i++) {
      v = Character.getNumericValue(digits[i]);
      if (9 - v < v) {
        v = 9 - v;
      }
      sb.append(v);
    }
    System.out.println(Long.parseLong(sb.toString()));
    sc.close();
  }
}
