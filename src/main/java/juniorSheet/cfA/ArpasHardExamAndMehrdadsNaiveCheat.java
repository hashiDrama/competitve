package juniorSheet.cfA;

import java.util.Scanner;

public class ArpasHardExamAndMehrdadsNaiveCheat {

  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    if (n == 0) {
      System.out.println(1);
      return;
    }
    n %= 4;
    if (n == 0) {
      System.out.println(6);
    } else if (n == 1) {
      System.out.println(8);
    } else if (n == 2) {
      System.out.println(4);
    } else {
      System.out.println(2);
    }

  }
}
