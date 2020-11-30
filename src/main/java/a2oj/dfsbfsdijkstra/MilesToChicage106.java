/*
 * SPOJ- 106 miles to Chicago; link-> https://www.spoj.com/problems/CHICAGO/
 */
package a2oj.dfsbfsdijkstra;

import java.util.Scanner;

public class MilesToChicage106 {

  private static double[][] adjMat;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line;
    while (true) {
      line = sc.nextLine();
      if (line.trim().equals("0"))
        break;
      int n = Integer.parseInt(line.substring(0, 1));
      int m = Integer.parseInt(line.substring(2, 3));
      adjMat = new double[n][n];
      int a, b, p;
      for (int i = 0; i < m; i++) {
        a = sc.nextInt() - 1;
        b = sc.nextInt() - 1;
        p = sc.nextInt();
        adjMat[a][b] = adjMat[b][a] = (double) p / 100;
      }
      sc.nextLine();
      // floyd warshall
      for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
          for (int j = 0; j < n; j++)
            adjMat[i][j] = Math.max(adjMat[i][j], adjMat[i][k] * adjMat[k][j]);
      System.out.printf("%.6f%n", adjMat[0][n - 1] * 100);
    }
    sc.close();
  }
}
