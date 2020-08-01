package juniorSheet.cfA;

import java.util.Scanner;

public class YaroslavAndPermutations {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int c;
    boolean valid = true;
    for (int i = 0; i < n; i++) {
      c = 0;
      for (int j = 0; j < n; j++) {
        if (a[i] == a[j]) {
          c++;
        }
      }
      if (n < 2 * c - 1) {
        valid = false;
        break;
      }
    }
    if (valid) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    sc.close();
  }
}
