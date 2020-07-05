package juniorSheet.cfA;

import java.util.Scanner;

public class Team {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int answered = 0;
    for(int t=0; t<n; t++) {
      int count = 0;
      for(int i=0; i<3; i++) {
        if(sc.nextInt() == 1) {
          count++;
        }
      }
      if(count >= 2) {
        answered++;
      }
    }
    System.out.println(answered);
    sc.close();
  }
}
