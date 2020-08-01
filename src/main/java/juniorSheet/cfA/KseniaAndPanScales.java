package juniorSheet.cfA;

import java.util.Scanner;

public class KseniaAndPanScales {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    String ans = sc.nextLine();

    int index = line.indexOf('|');
    StringBuilder left = new StringBuilder(line.substring(0, index));
    StringBuilder right = new StringBuilder(line.substring(index + 1));

    for (char c : ans.toCharArray()) {
      if (left.length() < right.length()) {
        left.append(c);
      } else {
        right.append(c);
      }
    }
    if (left.length() != right.length()) {
      System.out.println("Impossible");
    } else {
      System.out.println(left.toString() + "|" + right.toString());
    }
    sc.close();
  }
}
