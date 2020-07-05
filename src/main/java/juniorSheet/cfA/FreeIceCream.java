package juniorSheet.cfA;

import java.util.Scanner;

public class FreeIceCream {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long iceCreams = sc.nextInt();
    int distress = 0;
    for(int i=0; i<n; i++) {
      String c = sc.next();
      long d = sc.nextInt();
      if(c.charAt(0) == '+') {
        iceCreams+=d;
      } else {
        if(iceCreams<d) {
          distress++;
        } else {
          iceCreams-=d;
        }
      }
    }
    System.out.println(iceCreams + " " + distress);
    sc.close();
  }
}
