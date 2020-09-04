package juniorSheet.cfB;

import java.util.Scanner;

public class SumOfDigits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder num = new StringBuilder(sc.next());
    int sum = 0, count = 0;
    while (num.length() > 1) {
      sum = 0;
      for (char c : num.toString().toCharArray()) {
        sum += Character.getNumericValue(c);
      }
      count++;
      num.setLength(0);
      num.append(sum);
    }
    System.out.println(count);
    sc.close();
  }
}
