package juniorSheet.cfA;

import java.util.Scanner;

public class Keyboard {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ch = sc.next();
    String s = sc.next();
    String k1 = "qwertyuiop";
    String k2 = "asdfghjkl;";
    String k3 = "zxcvbnm,./";
    
    char[] c = new char[s.length()];
    int i=0;
    for(char keyword : s.toCharArray()) {
      if(ch.equals("R")) {
        if(k1.indexOf(keyword) >= 0) {
          c[i] = k1.charAt(k1.indexOf(keyword) - 1);
          i++;
        } else if(k2.indexOf(keyword) >= 0) {
          c[i] = k2.charAt(k2.indexOf(keyword) - 1);
          i++;
        } else {
          c[i] = k3.charAt(k3.indexOf(keyword) - 1);
          i++;
        }
      } else {
        if(k1.indexOf(keyword) >= 0) {
          c[i] = k1.charAt(k1.indexOf(keyword) + 1);
          i++;
        } else if(k2.indexOf(keyword) >= 0) {
          c[i] = k2.charAt(k2.indexOf(keyword) + 1);
          i++;
        } else {
          c[i] = k3.charAt(k3.indexOf(keyword) + 1);
          i++;
        }
      }
    }
    System.out.println(new String(c));
    sc.close();
    
  }
}
