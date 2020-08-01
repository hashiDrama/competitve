package juniorSheet.uva;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointsInFiguresRectangles {


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Rectangle> rectangles = new ArrayList<>();
    List<Point> points = new ArrayList<>();

    while (true) {
      String line = sc.nextLine();
      if (line.charAt(0) == '*') {
        continue;
      }
      String[] data = line.split(" ");
      if (data[0].equals("r")) {
        Point ul = new Point();
        ul.setX(Double.parseDouble(data[1]));
        ul.setY(Double.parseDouble(data[2]));

        Point lr = new Point();
        lr.setX(Double.parseDouble(data[3]));
        lr.setY(Double.parseDouble(data[4]));

        Rectangle rectangle = new Rectangle();
        rectangle.setUL(ul);
        rectangle.setLR(lr);

        rectangles.add(rectangle);
      } else if (data[0].equals("9999.9") && data[1].equals("9999.9")) {
        break;
      } else {
        Point p = new Point();
        p.setX(Double.parseDouble(data[0]));
        p.setY(Double.parseDouble(data[1]));

        points.add(p);
      }
    }

    boolean found;
    for (int i = 0; i < points.size(); i++) {
      found = false;
      for (int j = 0; j < rectangles.size(); j++) {
        if (isPointInsideRect(points.get(i), rectangles.get(j))) {
          System.out.println("Point " + (i + 1) + " is contained in figure " + (j + 1));
          found = true;
        }
      }
      if (!found) {
        System.out.println("Point " + (i + 1) + " is not contained in any figure");
      }
    }
    sc.close();
  }

  private static boolean isPointInsideRect(Point p, Rectangle rect) {
    return p.getX() > rect.getUL().getX() && p.getX() < rect.getLR().getX()
        && p.getY() < rect.getUL().getY() && p.getY() > rect.getLR().getY();
  }

  private static class Point {
    private double x;
    private double y;

    public double getX() {
      return this.x;
    }

    public void setX(double x) {
      this.x = x;
    }

    public double getY() {
      return this.y;
    }

    public void setY(double y) {
      this.y = y;
    }
  }

  private static class Rectangle {
    private Point ul;
    private Point lr;

    public Point getUL() {
      return this.ul;
    }

    public void setUL(Point ul) {
      this.ul = ul;
    }

    public Point getLR() {
      return this.lr;
    }

    public void setLR(Point lr) {
      this.lr = lr;
    }
  }
}
