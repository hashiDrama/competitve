/*
 * CF-687-A NP-Hard Problem; link -> https://codeforces.com/problemset/problem/687/A
 * 
 * This is basically a problem to find whether the given graph is bipartite or not and then return the 
 * bipartite graph parts if it is a bipartite.
 * Algo:
 * 1. Set color of all vertices = -1
 * 2. set color of source vertex = 1
 * 3. do bfs taking all vertices as source(this will make sure the disjoint components of graph have been colored as well)
 * 4. set color of adjacent vertices as opposite of current vertex. If color[curr] =1 then color[adjacent] = 0
 * 5. return the two parts by separating the vertices on the basis of colors.
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NPHardProblem {

  private static List<List<Integer>> adjList;
  private static int[] color;
  private static int n;

  // checking bipartite graph
  private static boolean bfs(int u) {
    Queue<Integer> q = new LinkedList<>();
    q.add(u);
    color[u] = 1;
    while (!q.isEmpty()) {
      u = q.poll();
      for (int v : adjList.get(u)) {
        if (color[v] == color[u])
          return false;
        if(color[v] == -1) {
          color[v] = 1 - color[u];
          q.add(v); 
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    int m = sc.nextInt();
    adjList = new ArrayList<>();
    for (int i = 0; i < n; i++)
      adjList.add(new ArrayList<>());
    int v1, v2;
    for (int i = 0; i < m; i++) {
      v1 = sc.nextInt() - 1;
      v2 = sc.nextInt() - 1;
      adjList.get(v1).add(v2);
      adjList.get(v2).add(v1);
    }
    color = new int[n];
    Arrays.fill(color, -1);
    for(int i=0; i< n; i++) {
      if(color[i] == -1 && !bfs(i)) {
        System.out.println(-1);
        return;
      }
    }
    List<Integer> zero = new ArrayList<>();
    List<Integer> one = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (color[i] == 0) {
        zero.add(i + 1);
      } else if(color[i] == 1){
        one.add(i + 1);
      }
    }
    System.out.println(zero.size());
    zero.forEach(i -> System.out.print(i + " "));
    System.out.println();
    System.out.println(one.size());
    one.forEach(i -> System.out.print(i + " "));
    System.out.println();
    sc.close();
  }
}
