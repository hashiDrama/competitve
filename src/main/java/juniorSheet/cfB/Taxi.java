package juniorSheet.cfB;

import java.util.Scanner;

public class Taxi {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    while (a < c) {
      if ((a + b) >= c) {
        a = c;
        break;
      }
      a += b;
      c -= d;
    }
    System.out.println(a);
    sc.close();
  }
}
