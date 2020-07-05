package juniorSheet.cfA;

import java.util.Scanner;

public class ColorfulStones {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    String t = sc.next();
    int pos = 0;
    for(char c: t.toCharArray()) {
      if(c == s.charAt(pos)) {
        pos++;
      }
    }
    System.out.println(pos+1);
    sc.close();
  }
}
