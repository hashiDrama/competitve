package juniorSheet.cfA;

import java.util.Scanner;

public class Juicer {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int b = sc.nextInt();
    int d = sc.nextInt();
    int size=0, count=0;
    for(int i=0; i<n; i++) {
      int num = sc.nextInt();
      if(num <= b) {
        size += num;
      }
      if(size>d) {
        count++;
        size=0;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
