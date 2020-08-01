package juniorSheet.cfA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int k = sc.nextInt();
    int count = 0;
    List<Integer> digOfn;
    for (int i = 0; i < N; i++) {
      int n = sc.nextInt();
      digOfn = new ArrayList<>();
      while (n > 0) {
        digOfn.add(n % 10);
        n /= 10;
      }
      boolean good = true;
      for (int j = 0; j <= k; j++) {
        if (!digOfn.contains(j)) {
          good = false;
          break;
        }
      }
      if (good) {
        count++;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
