package juniorSheet.cfA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DZYLovesHash {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int p = sc.nextInt();
    int n = sc.nextInt();
    boolean found = false;
    List<Integer> mod = new ArrayList<>();
    for(int i=0; i<n; i++) {
      int num = sc.nextInt();
      int temp = num%p;
      if(mod.contains(temp)) {
        found = true;
        System.out.println(i+1);
        break;
      }
      mod.add(temp);
    }
    if(!found) {
      System.out.println(-1); 
    }
    sc.close();
  }
}
