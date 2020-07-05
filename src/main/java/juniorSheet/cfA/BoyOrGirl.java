package juniorSheet.cfA;

import java.util.Scanner;

public class BoyOrGirl {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    char[] c = new char[128];
    for(char ch: name.toCharArray()) {
      c[ch]++;
    }
    int count = 0;
    for(int i=0; i<128; i++) {
      if(c[i] > 0) {
        count++;
      }
    }
    System.out.println((count % 2) != 0 ? "IGNORE HIM!" : "CHAT WITH HER!");
    sc.close();
  }
}
