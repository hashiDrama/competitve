package juniorSheet.cfA;

import java.util.Scanner;

public class BuyAShovel {

  private static int getMinPurchase(int k, int r) {
    if(k%10 == 0 || k%10 == r) {
      return 1;
    }
    int rem = k%10;
    int temp = k%10;
    int count = 1;
    while(rem%10 != 0 && rem%10 != r) {
      rem += temp;
      count++;
    }
    return count;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int r = sc.nextInt();
    System.out.println(getMinPurchase(k, r));
    sc.close();
  }
}
