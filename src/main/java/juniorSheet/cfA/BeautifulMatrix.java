package juniorSheet.cfA;

import java.util.Scanner;

public class BeautifulMatrix {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int oi=-1,oj=-1;
    for(int i=0; i<5; i++) {
      for(int j=0; j<5; j++) {
        if(sc.nextInt() == 1) {
          oi = i;
          oj = j;
          break;
        }
      }
      if(oi != -1) {
        break;
      }
    }
    System.out.println(Math.abs(oi - 2) + Math.abs(oj-2));
    sc.close();
  }
}
