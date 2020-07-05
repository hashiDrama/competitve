package juniorSheet.cfA;

import java.util.Scanner;

public class Magnets {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count=1;
    String s = sc.next();
    for(int i=0; i<n-1; i++) {
      String temp = sc.next();
      if(!s.equals(temp)) {
        count++;
        s = temp;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
