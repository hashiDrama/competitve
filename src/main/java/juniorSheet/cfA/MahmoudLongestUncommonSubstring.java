package juniorSheet.cfA;

import java.util.Scanner;

public class MahmoudLongestUncommonSubstring {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();
    if(s1.length() == s2.length()) {
      if(s1.contains(s2)) {
        System.out.println(-1);
      } else{
        System.out.println(s1.length());
      }
    } else {
      System.out.println(Math.max(s1.length(), s2.length()));
    }
    sc.close();
  }
}
