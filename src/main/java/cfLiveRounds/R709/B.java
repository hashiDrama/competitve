/*
 * 
 */
package cfLiveRounds.R709;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class B {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    OutputWriter out = new OutputWriter(System.out);
    TaskA solver = new TaskA();
    int t = in.readInt();
    solver.solve(t, in, out);
    out.flush();
    out.close();
  }

  static class TaskA {
    public void solve(int testCount, InputReader in, OutputWriter out) {
      while (testCount-- > 0) {
        int n = in.readInt();
        int[] a = in.readIntArray(n);
        // TODO: check n=1, 2
        if (a[0] > a[1]) {
          out.println(-1);
          continue;
        }
        int c = a[1] - a[0];
        int m = c + 1, s, max = -1;
        boolean possible, arbit = false;
        while (true) {
          s = m + a[0];
          possible = true;
          if (a[0] != s % m) {
            possible = false;
            break;
          }
          for (int i = 1; i < n; i++) {
            if (a[i] != (a[i - 1] + c) % m) {
              possible = false;
              break;
            }
          }
          if (possible)
            max = Math.max(max, m);
          else if (max != -1) {
            break;
          }
          if (m >= (int) 1e5) {
            arbit = true;
            break;
          }
          m += 10;
        }
        if (arbit)
          out.println(0);
        else
          out.println(max + " " + c);
      }
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
