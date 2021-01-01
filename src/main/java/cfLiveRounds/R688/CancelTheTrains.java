package cfLiveRounds.R688;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CancelTheTrains {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      List<Integer> big = new ArrayList<>();
      List<Integer> small = new ArrayList<>();
      if (n > m) {
        for (int i = 0; i < n; i++) {
          big.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
          small.add(sc.nextInt());
        }
      } else {
        for (int i = 0; i < n; i++) {
          small.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
          big.add(sc.nextInt());
        }
      }
      int ans = 0;
      for (int i = 0; i < small.size(); i++) {
        if (big.contains(small.get(i))) {
          ans++;
        }
      }
      System.out.println(ans);
    }
    sc.close();
  }
}
