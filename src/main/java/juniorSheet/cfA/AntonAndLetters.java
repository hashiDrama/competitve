package juniorSheet.cfA;

import java.util.Scanner;

public class AntonAndLetters {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    str = str.substring(1, str.length()-1);
    if(str.length()>0) {
      String[] letters = str.split(", ");
      char[] c = new char[128];
      for(String s: letters) {
        c[s.charAt(0)]++;
      }
      int count = 0;
      for(int i=0; i<128; i++) {
        if(c[i]>0) {
          count++;
        }
      }
      System.out.println(count); 
    }else {
      System.out.println(0);
    }
    sc.close();
  }
}
