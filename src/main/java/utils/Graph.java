package utils;

import java.util.Scanner;

public class Graph {

  void bfs(int[][] a, int u) {
    
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int noOfEdges;
    int[][] adjMatrix = new int[v][v];
    for (int i = 0; i < v; i++) {
      noOfEdges = sc.nextInt();
      while (noOfEdges-- > 0) {
        adjMatrix[i][sc.nextInt() - 1] = 1;
      }
    }
    for (int i = 0; i < v; i++) {
      for (int j = 0; j < v; j++)
        System.out.print(adjMatrix[i][j] + " ");
      System.out.println("");
    }
    sc.close();
  }
}
