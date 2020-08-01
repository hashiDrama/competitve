package juniorSheet.cfA;

import java.util.Scanner;

public class SnowFootprints {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.nextInt();
    String line = sc.next();
    int s = line.indexOf('R');
    int t = line.lastIndexOf('L');
    if (s == -1) {
      System.out.println(line.indexOf('L') + 1 + " " + (t + 1 + 1));
    } else if (t == -1) {
      System.out.println(s + 1 + " " + (line.lastIndexOf('R') - 1 + 1));
    } else {
      for (int i = s + 1; i < t; i++) {
        if (line.charAt(i) == 'L') {
          System.out.println(s + 1 + " " + (i - 1 + 1));
          return;
        }
      }
    }
    sc.close();
  }
}
