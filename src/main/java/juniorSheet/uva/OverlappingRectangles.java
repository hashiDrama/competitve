package juniorSheet.uva;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.Scanner;

public class OverlappingRectangles {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    StringBuilder res = new StringBuilder();
    for (int t = 0; t < T; t++) {
      sc.nextLine();
      sc.nextLine();
      int x1LL = sc.nextInt();
      int y1LL = sc.nextInt();
      int x1UR = sc.nextInt();
      int y1UR = sc.nextInt();

      int x2LL = sc.nextInt();
      int y2LL = sc.nextInt();
      int x2UR = sc.nextInt();
      int y2UR = sc.nextInt();

      if (x2LL < x1UR && y2LL < y1UR && x2UR > x1LL && y2UR > y1LL) {
        int xLL = max(x1LL, x2LL);
        int yLL = max(y1LL, y2LL);

        int xUR = min(x1UR, x2UR);
        int yUR = min(y1UR, y2UR);

        res.append(xLL + " " + yLL + " " + xUR + " " + yUR);
      } else {
        res.append("No Overlap");
      }
      if (t < T - 1) {
        res.append("\n\n");
      }

    }
    System.out.println(res.toString());
    sc.close();
  }
}
