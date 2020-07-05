package juniorSheet.cfA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeerjaAndDima {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int s=0, d=0;
    List<Integer> l = new ArrayList<>();
    for(int i=0; i<n; i++) {
      l.add(sc.nextInt());
    }
    while(!l.isEmpty()) {
      int i = l.get(0) > l.get(l.size() - 1) ? 0 : l.size()-1;
      s += l.get(i);
      l.remove(i);
      if(!l.isEmpty()) {
        i = l.get(0) > l.get(l.size() - 1) ? 0 : l.size()-1;
        d += l.get(i);
        l.remove(i);
      }
    }
    System.out.println(s + " " + d);
    sc.close();
  }
}
