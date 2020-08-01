package juniorSheet.cfA;

import java.util.Scanner;

public class DubStep {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String line = sc.next();
    String wub = "WUB";
    StringBuilder song = new StringBuilder();
    for (int i = 0; i < line.length();) {
      if (i < line.length() - 2 && wub.equals(line.substring(i, i + 3))) {
        if (song.length() == 0 || song.charAt(song.length() - 1) != ' ') {
          song.append(' ');
        }
        i += 3;
      } else {
        song.append(line.charAt(i));
        i++;
      }
    }
    System.out.println(song.toString().trim());
    sc.close();
  }
}
