package juniorSheet.spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeTreeHierarchy {

  static int[][] adj;
  static int[] visited;
  static List<Integer> top_sort_result;
  
  static void topological_sort(int i) {
    visited[i] = 1;
    for(int j=0; j<adj[i].length; j++) {
      if(adj[i][j] == 1 && visited[j] == 0) {
        topological_sort(j);
      }
    }
    top_sort_result.add(i);
  }
  
  public static void main(String[] args) {
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
      String next = reader.readLine();
      if(next == null || next.isEmpty()) {
        reader.close();
        return;
      }
      String[] data = next.split(" ");
      int N = Integer.parseInt(data[0]);
      int K = Integer.parseInt(data[1]);
      adj = new int[N][N];
      
      for(int k =0; k<K; k++) {
        data = reader.readLine().split(" ");
        int W = Integer.parseInt(data[0]);
        for(int i=0; i<W; i++) {
          int child = Integer.parseInt(data[i+1]);
          adj[k][child-1] = 1;
        }
      }
      visited = new int[N];
      top_sort_result = new ArrayList<>();
      for(int i=0; i<N; i++) {
        if(visited[i] == 0) {
          topological_sort(i);
        }
      }
      
      int[] parent = new int[N];
      //3 1 4 2
      Collections.reverse(top_sort_result);
      int position = -1;
      for(int i=0; i<N; i++) {
        int student = top_sort_result.get(i);
        parent[student] = position;
        position = student;
      }
      
      for(int i=0; i<N; i++) {
        System.out.println((parent[i]+1) + " ");
      }
    }catch(Exception e) {
      e.printStackTrace();
    }
    
  }
}
