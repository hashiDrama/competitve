package juniorSheet.cfA;

import java.util.Scanner;

public class TuringTape {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[] arr = sc.nextLine().toCharArray();
    int prev = 0;
    for(char c : arr) {
      StringBuilder s = new StringBuilder(Integer.toString((int)c, 2));
      while(s.length()<8)
        s.insert(0, '0');
      s.reverse();
      int x = Integer.parseInt(s.toString(), 2);
      System.out.println((prev-x+256)%256);
      prev=x;
    }
    sc.close();
  }
}
