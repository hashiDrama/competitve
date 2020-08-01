package juniorSheet.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderingTasks {

  static int[][] adj;
  static int[] visited;
  static List<Integer> top_sort;

  static void topological_sort(int i) {
    visited[i] = 1;
    for (int j = 0; j < adj[i].length; j++) {
      if (adj[i][j] == 1 && visited[j] == 0) {
        topological_sort(j);
      }
    }
    top_sort.add(i);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String line = reader.readLine();
      if (line == null || line.isEmpty()) {
        return;
      }
      String[] data = line.split(" ");
      int n = Integer.parseInt(data[0]);
      int m = Integer.parseInt(data[1]);
      if (n == 0 && m == 0) {
        break;
      }
      adj = new int[n][n];

      for (int i = 0; i < m; i++) {
        data = reader.readLine().split(" ");
        int parent = Integer.parseInt(data[0]);
        int child = Integer.parseInt(data[1]);
        adj[parent - 1][child - 1] = 1;
      }
      visited = new int[n];
      top_sort = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (visited[i] == 0) {
          topological_sort(i);
        }
      }
      Collections.reverse(top_sort);
      System.out.println();
      top_sort.forEach(d -> System.out.print((d+1) + " "));
      System.out.println();
    }
  }
}
