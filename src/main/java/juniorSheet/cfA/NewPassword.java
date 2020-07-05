package juniorSheet.cfA;

import java.util.Scanner;

public class NewPassword {

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int i = 0, limit = k-1;
    StringBuilder pswrd = new StringBuilder();
    while(pswrd.length()<n) {
      pswrd.append((char)('a'+i));
      i = i<limit ? i+1 : 0;
    }
    System.out.println(pswrd.toString());
    sc.close();
  }
}
