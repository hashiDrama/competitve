package juniorSheet.cfA;

import java.util.Scanner;

public class IsItRated {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    boolean rated = false, unrated = false;
    for (int i = 0; i < n; i++) {
      int ai = sc.nextInt();
      int bi = sc.nextInt();
      if (ai != bi) {
        System.out.println("rated");
        rated = true;
        break;
      }
      if (i > 0 && ai > a[i - 1]) {
        unrated = true;
      }
      a[i] = ai;
    }
    if (!rated && unrated) {
      System.out.println("unrated");
    } else if (!rated) {
      System.out.println("maybe");
    }
    sc.close();
  }
}
