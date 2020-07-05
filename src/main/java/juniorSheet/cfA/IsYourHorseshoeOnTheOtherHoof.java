package juniorSheet.cfA;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsYourHorseshoeOnTheOtherHoof {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Set<Integer> colors = new HashSet<>();
    for(int i=0; i<4; i++) {
      colors.add(sc.nextInt());
    }
    System.out.println(4-colors.size());
    sc.close();
  }
}
