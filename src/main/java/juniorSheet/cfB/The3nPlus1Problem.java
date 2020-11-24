package juniorSheet.cfB;

import java.util.Scanner;

public class The3nPlus1Problem {

  static int cycle(int n) {
    if (n == 1)
      return 1;
    if (n % 2 != 0)
      n = 3 * n + 1;
    else
      n = n / 2;
    return 1 + cycle(n);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int from, to;
    while (sc.hasNext()) {
      int I = sc.nextInt();
      int J = sc.nextInt();
      
      from = Math.min(I, J);
      to = Math.max(I,J);

      int max = Integer.MIN_VALUE;
      for (int i = from; i <= to; i++) {
        max = Math.max(max, cycle(i));
      }

      System.out.println(I + " " + J + " " + max);
    }
  }

}
