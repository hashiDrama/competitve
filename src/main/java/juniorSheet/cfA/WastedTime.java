package juniorSheet.cfA;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;

public class WastedTime {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int k = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    double d = 0;
    int x1, y1;
    for (int n = 0; n < N - 1; n++) {
      x1 = sc.nextInt();
      y1 = sc.nextInt();
      d += sqrt(pow(x - x1, 2) + pow(y - y1, 2));
      x = x1;
      y = y1;
    }
    System.out.println(String.format("%.9f",(d / 50) * k));
    sc.close();
  }
}
