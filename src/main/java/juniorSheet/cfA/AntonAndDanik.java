package juniorSheet.cfA;

import java.util.Scanner;

public class AntonAndDanik {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int ca=0, cd=0;
    int n =sc.nextInt();
    String s = sc.next();
    for(char c: s.toCharArray()) {
      if(c == 'A') {
        ca++;
      }
      else if(c == 'D') {
        cd++;
      }
    }
    if(ca==cd) {
      System.out.println("Friendship");
    } else if(ca>cd) {
      System.out.println("Anton");
    } else {
      System.out.println("Danik");
    }
    sc.close();
  }
}
