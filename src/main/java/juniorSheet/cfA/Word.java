package juniorSheet.cfA;

import java.util.Scanner;

public class Word {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int u=0, l=0;
    for(char c: s.toCharArray()) {
      if(Character.isUpperCase(c)) {
        u++;
      }else {
        l++;
      }
    }
    if(u>l) {
      s = s.toUpperCase();
    }else {
      s = s.toLowerCase();
    }
    System.out.println(s);
    sc.close();
  }
}
