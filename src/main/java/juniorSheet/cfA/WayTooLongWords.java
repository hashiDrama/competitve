package juniorSheet.cfA;

import java.util.Scanner;

public class WayTooLongWords {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int i=0; i<n; i++) {
      String w = sc.next();
      if(w.length()>10) {
        w = new StringBuilder().append(w.charAt(0)).append(w.length()-2).append(w.charAt(w.length()-1)).toString();
      }
      System.out.println(w);
    }
    sc.close();
  }
}
