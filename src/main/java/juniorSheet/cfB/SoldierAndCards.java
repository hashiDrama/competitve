/*
 * http://codeforces.com/contest/546/problem/C
 */
package juniorSheet.cfB;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Deque;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Map;

public class SoldierAndCards {

  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    OutputWriter out = new OutputWriter(System.out);
    TaskA solver = new TaskA();
    solver.solve(1, in, out);
    out.flush();
    out.close();
  }

  static class TaskA {
    public void solve(int testCount, InputReader in, OutputWriter out) {
      while (testCount-- > 0) {
        int n = in.readInt();
        int k1 = in.readInt();
        Deque<Integer> d1 = new LinkedList<>();
        Deque<Integer> d2 = new LinkedList<>();
        for (int i = 0; i < k1; i++)
          d1.add(in.readInt());
        int k2 = in.readInt();
        for (int i = 0; i < k2; i++)
          d2.add(in.readInt());
        boolean pos = true;
        int ans = 0, winner = -1;
        int t1, t2;
        String ts;
        Map<String, Boolean> map = new HashMap<>();
        while (true) {
          if (d1.isEmpty()) {
            winner = 2;
            break;
          }
          if (d2.isEmpty()) {
            winner = 1;
            break;
          }
          t1 = d1.pollFirst();
          t2 = d2.pollFirst();
          if (t1 > t2) {
            d1.addLast(t2);
            d1.addLast(t1);
          } else {
            d2.addLast(t1);
            d2.addLast(t2);
          }
          ts = "";
          for (Integer i : d1)
            ts += i;
          ts += "$";
          for (Integer i : d2)
            ts += i;
          if (map.containsKey(ts)) {
            pos = false;
            break;
          }
          map.put(ts, true);
          ans++;
        }
        if (!pos)
          out.println(-1);
        else
          out.println(ans + " " + winner);
      }
    }
  }

  static class Search {

    public static int binarySearch(int[] a, int val) {
      int l = 0, r = a.length, mid;
      while (l < r) {
        mid = (l + r) / 2;
        if (mid == 0)
          return 1;
        if (a[mid] == val)
          return mid + 1;
        if (a[mid] > val) {
          if (a[mid - 1] < val)
            return mid + 1;
          else
            r = mid;
        } else {
          l = mid;
        }
      }
      return 1;
    }
  }

  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int currChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int[] readIntArray(int size) {
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = readInt();
      }
      return array;
    }

    public int read() {
      if (numChars == -1)
        throw new InputMismatchException();
      if (currChar >= numChars) {
        currChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0)
          return -1;
      }
      return buf[currChar++];
    }

    public String readString() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c))
        c = read();
      int sign = 1;
      if (c == '-') {
        sign = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sign;
    }

    public boolean isSpaceChar(int c) {
      if (filter != null)
        return filter.isSpaceChar(c);
      return isWhiteSpace(c);
    }

    public static boolean isWhiteSpace(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);
    }
  }

  private static class OutputWriter {
    private PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
      writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; i++) {
        if (i != 0) {
          writer.print(' ');
        }
        writer.print(objects[i]);
      }
    }

    public void println(Object... objects) {
      print(objects);
      writer.println();
    }

    public void close() {
      writer.close();
    }

    public void flush() {
      writer.flush();
    }
  }


}
