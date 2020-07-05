package juniorSheet.cfA;

import java.util.Scanner;

public class VanyaAndFence {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int h = sc.nextInt();
    int count = 0;
    for(int i=0; i<n; i++) {
      if(sc.nextInt() > h) {
        count++;
      }
      count++;
    }
    System.out.println(count);
    sc.close();
  }
}
