package cfLiveRounds.R658;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipPrefixEasyVersion {

  static char[] revert(char[] a, int i) {
    for (int k = 0; k < i; k++) {
      a[i] = a[i] == '0' ? '1' : '0';
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      char[] a = sc.next().toCharArray();
      char[] b = sc.next().toCharArray();

      List<Integer> count = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (a[i] != b[i]) {
          if (i > 0) {
            a = revert(a, i - 1);
            count.add(i);
          }
          a = revert(a, i);
          count.add(i+1);
        }
      }
      System.out.print(count.size() + " ");
      count.forEach(c -> System.out.print(c + " "));
      System.out.println();
    }
    sc.close();
  }
}
