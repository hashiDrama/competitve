/*
 * http://codeforces.com/contest/371/problem/B
 */
package juniorSheet.cfB;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class FoxDividingCheese {

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
        int a = in.readInt();
        int b = in.readInt();

        int a2 = 0, a3 = 0, a5 = 0;
        int b2 = 0, b3 = 0, b5 = 0;
        while (a % 2 == 0) {
          a /= 2;
          a2++;
        }
        while (a % 3 == 0) {
          a /= 3;
          a3++;
        }
        while (a % 5 == 0) {
          a /= 5;
          a5++;
        }
        while (b % 2 == 0) {
          b /= 2;
          b2++;
        }
        while (b % 3 == 0) {
          b /= 3;
          b3++;
        }
        while (b % 5 == 0) {
          b /= 5;
          b5++;
        }
        if (a != b) {
          out.println(-1);
          continue;
        }
        int ans = Math.abs(a2 - b2) + Math.abs(a3 - b3) + Math.abs(a5 - b5);
        out.println(ans);
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
