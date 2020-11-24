package juniorSheet.cfB;

import java.util.Scanner;

public class BrowniePoints {

  private static class Point {
    int x;
    int y;
  }

  static boolean stanWon(Point pi, Point mid) {
    return (pi.x > mid.x && pi.y > mid.y) || (pi.x < mid.x && pi.y < mid.y);
  }
  
  static boolean olieWon(Point pi, Point mid) {
    return (pi.x < mid.x && pi.y > mid.y) || (pi.x > mid.x && pi.y < mid.y);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if (n == 0)
        break;
      Point[] points = new Point[n];
      for (int i = 0; i < n; i++) {
        Point pi = new Point();
        pi.x = sc.nextInt();
        pi.y = sc.nextInt();

        points[i] = pi;
      }

      int mid = (n / 2);
      Point midP = points[mid];

      int stan = 0, olie = 0;
      for (int i = 0; i < n; i++) {
        if(i!=mid) {
          if (stanWon(points[i], midP))
            stan++;
          else if(olieWon(points[i], midP))
            olie++; 
        }
      }
      System.out.println(stan + " " + olie);
    }
    sc.close();
  }
}
