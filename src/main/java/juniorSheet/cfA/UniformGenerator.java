package juniorSheet.cfA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniformGenerator {

  private static boolean isGoodChoice(int s, int m) {
    int i;
    int temp=s%m;
    i=temp;
    List<Integer> list = new ArrayList<>();
    list.add(i);
    while(true) {
      i = (i+s)%m;
      if(i == temp) {
        if(list.size()<m) {
          return false;
        }
        return true;
      }
      list.add(i);
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int s = sc.nextInt();
      int m = sc.nextInt();
      boolean b = isGoodChoice(s, m);
      System.out.printf("%10d%10d%5s%s", s, m, "     ", b==true? "Good Choice" : "Bad Choice");
    }
  }
}