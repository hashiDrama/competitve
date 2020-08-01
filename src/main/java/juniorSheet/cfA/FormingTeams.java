package juniorSheet.cfA;

import java.util.Scanner;

public class FormingTeams {

  static int[] vertex;
  static int[] visited;
  static int[][] adj;
  static int[] color;
  static int count = 0;
  
  private static void checkBipartiteUsingDFS(int idx, int clr) {
    color[idx] = clr;
    visited[idx] = 1;
    for(int i=0; i<vertex.length; i++) {
      if(i != idx && adj[idx][i] == 1 && color[i] == clr) {
        count++;
      }
      else if(adj[idx][i] == 1 && visited[i] == 0 && color[i] != clr) {
        checkBipartiteUsingDFS(i, clr == 1 ? 2 : 1);
      }
    }
  }
  
  private static void formTeam() {
    for(int i=0; i<color.length; i++) {
      if(color[i] == 0) {
        checkBipartiteUsingDFS(i, 1);
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    
    vertex = new int[n];
    adj = new int[n][n];
    visited = new int[n];
    color = new int[n];
    
    for(int i=0; i<m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      adj[x-1][y-1] = 1;
      adj[y-1][x-1] = 1;
    }
    formTeam();
    count /= 2;
    if((n-count) % 2 != 0) {
      System.out.println(count + 1);
    }else {
      System.out.println(count);
    }
    sc.close();
  }
}
