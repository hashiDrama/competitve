package juniorSheet.cfB;

import java.util.Scanner;

public class LovelyPalindromes {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String palindrome = s + new StringBuilder(s).reverse().toString();
    System.out.println(palindrome);
    sc.close();
  }
}
