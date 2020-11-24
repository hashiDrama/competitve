  /*
   * uva - 10034, link ->
   * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=975
   */
  
  package a2oj.dfsbfsdijkstra;
  
  import static java.lang.Math.pow;
  import static java.lang.Math.sqrt;
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.PriorityQueue;
  import java.util.StringTokenizer;
  
  public class Freckles {
  
    private static List<Edge> adjList;
    private static int n;
  
    private static double kruskals() {
      PriorityQueue<Edge> pq = new PriorityQueue<>();
      DisjointSet ds = new DisjointSet(n);
      for (Edge e : adjList) {
        pq.add(e);
      }
      double mstVal = 0.0;
      while (!pq.isEmpty()) {
        Edge e = pq.poll();
        if (ds.union(e.from, e.to)) {
          mstVal += e.w;
        }
      }
      return mstVal;
    }
  
    private static double findDistance(Point from, Point to) {
      return sqrt(pow(from.x - to.x, 2) + pow(from.y - to.y, 2));
    }
  
    public static void main(String[] args) {
      FastReader fr = new FastReader();
      int t = fr.nextInt();
      fr.nextLine();
      while (t-- > 0) {
        n = fr.nextInt();
        List<Point> pts = new ArrayList<>();
        double x, y;
        for (int i = 0; i < n; i++) {
          x = fr.nextDouble();
          y = fr.nextDouble();
          pts.add(new Point(x, y));
        }
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
            adjList.add(new Edge(i, j, findDistance(pts.get(i), pts.get(j))));
          }
        }
        System.out.printf("%.2f\n", kruskals());
        if(t != 0)
          System.out.println();
        fr.nextLine();
      }
    }
  
    private static class DisjointSet {
      int n;
      int[] parent;
      int[] rank;
  
      public DisjointSet(int n) {
        this.n = n;
        this.parent = new int[this.n];
        this.rank = new int[this.n];
        for (int i = 0; i < n; i++) {
          parent[i] = i;
          rank[i] = i;
        }
      }
  
      public int find(int i) {
        if (parent[i] == i)
          return i;
        return parent[i] = find(parent[i]);
      }
  
      public boolean union(int i, int j) {
        int irep = find(i);
        int jrep = find(j);
        if (irep == jrep)
          return false;
        int irank = rank[irep];
        int jrank = rank[jrep];
        if (irank > jrank) {
          parent[jrep] = irep;
        } else {
          parent[irep] = jrep;
        }
        if (irep == jrep) {
          rank[jrep]++;
        }
        return true;
      }
    }
  
    private static class Point {
      double x;
      double y;
  
      public Point(double x, double y) {
        this.x = x;
        this.y = y;
      }
    }
  
    private static class Edge implements Comparable<Edge> {
      int from;
      int to;
      double w;
  
      public Edge(int from, int to, double w) {
        this.from = from;
        this.to = to;
        this.w = w;
      }
  
      @Override
      public int compareTo(Edge e) {
        return this.w > e.w ? 1 : this.w < e.w ? -1 : 0;
      }
    }
  
    private static class FastReader {
      BufferedReader br;
      StringTokenizer st;
  
      public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
      }
  
      String next() {
        while (st == null || !st.hasMoreElements()) {
          try {
            st = new StringTokenizer(br.readLine());
          } catch (IOException e) {
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
  
      double nextDouble() {
        return Double.parseDouble(next());
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
