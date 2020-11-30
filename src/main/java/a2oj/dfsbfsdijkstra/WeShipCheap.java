/*
 * uva-762 We Ship Cheap;
 * link -> https://onlinejudge.org/external/7/762.pdf
 */
package a2oj.dfsbfsdijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WeShipCheap {
  
  private static Map<String, List<String>> graph;
  private static Map<String, Boolean> vis;
  private static Map<String, String> parent;
  
  private static void bfs(String src, String dest) {
    Queue<String> q= new LinkedList<>();
    vis = new HashMap<>();
    parent = new HashMap<>();
    for(String key : graph.keySet()) {
      vis.put(key, false);
    }
    q.add(src);
    parent.put(src, src);
    String top;
    while(!q.isEmpty()) {
      top = q.poll();
      if(top.equals(dest))
        break;
      vis.put(top, true);
      for(String v : graph.get(top)) {
        if(!vis.get(v)) {
          if(!parent.containsKey(v))
            parent.put(v, top);  
          q.add(v);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line;
    while(sc.hasNextLine()) {
      int n = sc.nextInt();
      sc.nextLine();
      graph = new HashMap<>();
      String c1,c2;
      List<String> list;
      String[] data;
      for(int i=0; i<n; i++) {
        data = sc.nextLine().split(" ");
        c1 = data[0];
        c2 = data[1];
        if(!graph.containsKey(c1))
           list = new ArrayList<>();
        else {
          list = graph.get(c1);
        }
        list.add(c2);
        graph.put(c1, list);
        if(!graph.containsKey(c2))
          list = new ArrayList<>();
        else {
          list = graph.get(c2);
        }
        list.add(c1);
        graph.put(c2, list);
      }
      data = sc.nextLine().split(" ");
      String src = data[0];
      String dest = data[1];
      if(!graph.containsKey(src)) {
        System.out.println("No route\n");
        continue;
      }
      bfs(src, dest);
      if(!parent.containsKey(dest))
        System.out.println("No route\n");
      else {
        List<String> ans = new ArrayList<>();
        String temp = dest;
        while(!temp.equals(src)) {
          ans.add(temp);
          temp = parent.get(temp);
        }
        ans.add(src);
        Collections.reverse(ans);
        for(int i = 0; i<ans.size()-1; i++) {
          System.out.println(ans.get(i) + " " + ans.get(i+1));
        }
        System.out.println();
      }
    }
  }
  
  private static class Pair implements Comparable<Pair>{
    String first;
    int second;
    public Pair(String first, int second) {
      this.first = first;
      this.second = second;
    }
    
    @Override
    public int compareTo(Pair p) {
      return this.second < p.second ? -1 :
        this.second > p.second ? 1 : 0;
    }
  }
  
  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    boolean hasNext() {
      try {
        return br.ready();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return false;
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
