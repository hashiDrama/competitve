package juniorSheet.cfA;

import java.util.Scanner;

public class NightAtTheMuseum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    char current = 'a';
    int count=0;
    for(char c: s.toCharArray()) {
      count += Math.min(26-Math.abs(current-c), Math.abs(current-c));
      current = c;
    }
    System.out.println(count);
    sc.close();
  }
}
