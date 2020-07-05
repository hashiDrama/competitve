package juniorSheet.cfA;

import java.util.Scanner;

public class PoliceRecruits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int r=0, c=0;
    for(int i=0; i<n; i++) {
      int event = sc.nextInt();
      if(event > 0) {
        r+=event;
        continue;
      }
      if(r > 0) {
        r--;
        continue;
      }
      c++;
    }
    System.out.println(c);
    sc.close();
  }
}
