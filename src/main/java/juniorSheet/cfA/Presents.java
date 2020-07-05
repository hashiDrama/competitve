package juniorSheet.cfA;

import java.util.HashMap;
import java.util.Scanner;

public class Presents {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<n; i++) {
      map.put(sc.nextInt(), i);
    }
    for(int i=0; i<n; i++) {
      System.out.print(map.get(i+1)+1 + " ");
    }
    System.out.println();
    sc.close();
  }
}
