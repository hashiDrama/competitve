// uva -10998 - https://onlinejudge.org/external/109/10998.pdf

package juniorSheet.cfB;

import java.util.Scanner;

public class FlippingColors {

  // In every call it is checking if the point lies before the new (h, v) or after and accordingly
  // calls method with new H, V values
  static boolean dfs(double H, double V, double h, double v, double x, double y, boolean color) {
    double mx = H * h;
    double my = V * v;

    if (x <= mx && y >= my)
      return color; // upper left
    if (x >= mx && y <= my)
      return color; // lower right
    if (x <= mx)
      return dfs(H * h, V * v, h, v, x, y, !color);
    else
      return dfs(H * (1 - h), V * (1 - v), h, v, x - mx, y - my, !color);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double H, V, h, v, x, y;
    int n, cases = 1;
    while (true) {
      H = sc.nextDouble();
      V = sc.nextDouble();
      h = sc.nextDouble();
      v = sc.nextDouble();
      if (H == 0 && V == 0 && h == 0 && v == 0)
        break;
      n = sc.nextInt();
      System.out.println("Case " + cases + ":");
      while (n-- > 0) {
        x = sc.nextDouble();
        y = sc.nextDouble();
        boolean color = dfs(H, V, h, v, x, y, true);
        System.out.println(color ? "black" : "white");
      }
      cases++;
    }
    sc.close();
  }
}
