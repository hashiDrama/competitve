/*
 * https://www.codechef.com/START1C/problems/ADMIT
 */
package cchefLiveRounds.codechefStarters2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem5 {

  public static void main(String[] args) throws Exception {
    FastReader reader = new FastReader();
    String line = reader.nextLine();
    if (line == null)
      return;
    int t = Integer.parseInt(line);
    while (t-- > 0) {
      String[] data = reader.nextLine().trim().split(" ");
      int n = Integer.parseInt(data[0]);
      int m = Integer.parseInt(data[1]);
      Map<Integer, Integer> clgRankIdMap = new HashMap<>();
      data = reader.nextLine().trim().split(" ");
      for (int i = 0; i < data.length; i++)
        clgRankIdMap.put(Integer.parseInt(data[i]), i);
      Map<Integer, Boolean> filled = new HashMap<>();

      Map<Integer, Integer> studentRankIdMap = new HashMap<>();
      data = reader.nextLine().trim().split(" ");
      int chefRank = -1;
      for (int i = 0; i < data.length; i++) {
        studentRankIdMap.put(Integer.parseInt(data[i]), i);
        if (i == 0)
          chefRank = Integer.parseInt(data[i]);
      }

      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < m; i++) {
        data = reader.nextLine().trim().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j < data.length; j++)
          list.add(Integer.parseInt(data[j]));
        list.sort(null);
        map.put(i, list);
      }

      for (int i = 1; i < chefRank; i++) {
        List<Integer> cRanks = map.get(studentRankIdMap.get(i));
        for (int j = 0; j < cRanks.size(); j++) {
          if (!filled.containsKey(cRanks.get(j))) {
            filled.put(cRanks.get(j), true);
            break;
          }
        }
      }

      List<Integer> chefClgRanks = map.get(0);
      int chefClgRank = 0;
      for (int i = 0; i < chefClgRanks.size(); i++) {
        if (!filled.containsKey(chefClgRanks.get(i))) {
          chefClgRank = chefClgRanks.get(i);
          break;
        }
      }
      if (chefClgRank == 0)
        System.out.println(0);
      else
        System.out.println(clgRankIdMap.get(chefClgRank) + 1);
    }
  }

  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      this.br = new BufferedReader(new InputStreamReader(System.in));
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
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}
