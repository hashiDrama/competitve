package juniorSheet.cfA;

import java.util.Scanner;

public class CarrotCakes {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int t = sc.nextInt();
    int k = sc.nextInt();
    int d = sc.nextInt();
    float singleOvenTime = ((float)n*t)/k;
    float doubleOvenTime = (singleOvenTime/2)+d;
    System.out.println(doubleOvenTime<singleOvenTime ? "YES" : "NO");
    sc.close();
  }
}
