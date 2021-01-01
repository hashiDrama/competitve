/*
 * UVA-10171 Meeting Prof. Miguel; link ->
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1112
 */
package a2oj.dfsbfsdijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MeetingProfMiguel {

  private static final int INF = Integer.MAX_VALUE;

  private static List<List<Path>> adjList;
  private static int[] d1, d2;
  private static boolean[] vis;
  private static int n;

  private static void dijkstra(int u, int[] d) {
    Arrays.fill(d, INF);
    PriorityQueue<Path> pq = new PriorityQueue<>();
    d[u] = 0;
    pq.add(new Path(u, true, d[u]));
    Path p;
    while (!pq.isEmpty()) {
      p = pq.poll();
      if (vis[p.to])
        continue;
      vis[p.to] = true;
      for (Path v : adjList.get(p.to)) {
        if (d[v.to] > d[p.to] + v.length) {
          d[v.to] = d[p.to] + v.length;
          pq.add(new Path(v.to, v.elders, d[v.to]));
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      sc.nextLine();
      if (n == 0)
        break;
      String[] line;
      char bidir;
      int length, from, to;
      boolean elder;
      adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        line = sc.nextLine().split(" ");
        if (line[0].charAt(0) == 'Y')
          elder = false;
        else
          elder = true;
        bidir = line[1].charAt(0);
        from = line[2].charAt(0) - 'A';
        to = line[3].charAt(0) - 'A';
        length = Integer.parseInt(line[4]);
        if (bidir == 'B') {
          while(adjList.size() < to)
            adjList = new ArrayList<>();
          adjList.get(to).add(new Path(from, elder, length));
        }
        if (!adjList.contains(from))
          adjList = new ArrayList<>();
        adjList.get(from).add(new Path(to, elder, length));
      }
      line = sc.nextLine().split(" ");
      from = line[0].charAt(0) - 'A';
      to = line[1].charAt(0) - 'A';
      n = adjList.size();
      d1 = new int[n];
      d2 = new int[n];
      vis = new boolean[n];
      dijkstra(from, d1);
      dijkstra(to, d2);
      int ans = INF, idx = -1;
      for (int i = 0; i < n; i++) {
        if (d1[i] != INF && d2[i] != INF) {
          if (ans > (d1[i] + d2[i])) {
            ans = Math.min(ans, d1[i] + d2[i]);
            idx = i;
          }
        }
      }
      if (idx == -1)
        System.out.println("You will never meet.");
      else
        System.out.println(ans + " " + ((char) ('A' + idx)));
    }
  }

  private static class Path implements Comparable<Path> {
    int to;
    boolean elders;
    int length;

    public Path(int to, boolean elders, int length) {
      this.to = to;
      this.elders = elders;
      this.length = length;
    }

    @Override
    public int compareTo(Path p) {
      return this.length < p.length ? -1 : this.length > p.length ? 1 : 0;
    }
  }
}
