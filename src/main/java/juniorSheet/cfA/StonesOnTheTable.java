package juniorSheet.cfA;

import java.util.Scanner;

public class StonesOnTheTable {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    String s = sc.next();
    char[] c = s.toCharArray();
    int count = 0;
    for(int i=0; i<c.length-1; i++) {
      if(c[i] == c[i+1]) {
        count++;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
