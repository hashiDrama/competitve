package juniorSheet.uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class FourthPoint {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    DecimalFormat df = new DecimalFormat("0.000");
    String line;
    while ((line = br.readLine()) != null && !line.isEmpty()) {
      String[] data = line.split(" ");
      double x1 = Double.parseDouble(data[0]);
      double y1 = Double.parseDouble(data[1]);
      double x2 = Double.parseDouble(data[2]);
      double y2 = Double.parseDouble(data[3]);
      double x3 = Double.parseDouble(data[4]);
      double y3 = Double.parseDouble(data[5]);
      double x4 = Double.parseDouble(data[6]);
      double y4 = Double.parseDouble(data[7]);

      if (x1 == x2 && y1 == y2) {
        System.out.println(df.format(x3 + x4 - x1) + " " + df.format(y3 + y4 - y1));
        continue;
      }
      if (x2 == x3 && y2 == y3) {
        System.out.println(df.format(x1 + x4 - x2) + " " + df.format(y1 + y4 - y2));
        continue;
      }
      if (x3 == x4 && y3 == y4) {
        System.out.println(df.format(x1 + x2 - x3) + " " + df.format(y1 + y2 - y3));
        continue;
      }
      System.out.println(df.format(x2 + x3 - x1) + " " + df.format(y2 + y3 - y1));
    }
  }

  static class FastInput {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastInput() {
      reader = new BufferedReader(new InputStreamReader(System.in));
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreElements()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public String nextLine() {
      try {
        return reader.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
