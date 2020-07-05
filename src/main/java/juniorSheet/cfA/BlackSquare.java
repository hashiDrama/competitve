package juniorSheet.cfA;

import java.util.Scanner;

public class BlackSquare {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a1=sc.nextInt();
    int a2=sc.nextInt();
    int a3=sc.nextInt();
    int a4=sc.nextInt();
    String s = sc.next();
    int calorie = 0;
    for(char c: s.toCharArray()) {
      int value = Character.getNumericValue(c);
      if(value == 1) {
        calorie += a1;
      }else if(value == 2) {
        calorie += a2;
      }else if(value == 3) {
        calorie += a3;
      }else if(value == 4) {
        calorie += a4;
      }
    }
    System.out.println(calorie);
    sc.close();
  }
}
