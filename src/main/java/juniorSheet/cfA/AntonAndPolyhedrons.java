package juniorSheet.cfA;

import java.util.Scanner;

public class AntonAndPolyhedrons {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count = 0;
    String line;
    for (int i = 0; i < n; i++) {
      line = sc.next();
      if (line.equals("Tetrahedron")) {
        count += 4;
      } else if (line.equals("Cube")) {
        count += 6;
      } else if (line.equals("Octahedron")) {
        count += 8;
      } else if (line.equals("Dodecahedron")) {
        count += 12;
      } else if (line.equals("Icosahedron")) {
        count += 20;
      }
    }
    System.out.println(count);
    sc.close();
  }
}
