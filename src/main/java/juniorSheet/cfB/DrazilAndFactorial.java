/*
 * http://codeforces.com/contest/515/problem/C
 */
package juniorSheet.cfB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class DrazilAndFactorial {

  public static void main(String[] args) {
    FastReader fr = new FastReader();
    int n = fr.nextInt();
    String a = fr.next();
    Map<Character, String> map = new HashMap<>();
    map.put('0', "");
    map.put('1', "");
    map.put('2', "2");
    map.put('3', "3");
    map.put('4', "322");
    map.put('5', "5");
    map.put('6', "53");
    map.put('7', "7");
    map.put('8', "7222");
    map.put('9', "7332");

    StringBuilder b = new StringBuilder();
    for (char c : a.toCharArray()) {
      b.append(map.get(c));
    }
    List<Integer> list = new ArrayList<>();
    for (char c : b.toString().toCharArray()) {
      list.add(c - '0');
    }
    list.sort((i1, i2) -> Integer.compare(i2, i1));
    String ans = list.stream().map(Object::toString).collect(Collectors.joining(""));
    System.out.println(ans);
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
