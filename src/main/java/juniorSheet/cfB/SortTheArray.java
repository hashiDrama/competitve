package juniorSheet.cfB;

import java.util.Arrays;
import java.util.Scanner;

public class SortTheArray {

  static void reverse(int[] a, int l, int r) {
    int[] t = new int[a.length];
    for (int i = l, j = r; i <= r; i++, j--) {
      t[i] = a[j];
    }
    for (int i = l; i <= r; i++) {
      a[i] = t[i];
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      b[i] = a[i];
    }
    Arrays.sort(b);
    int l = -1, r = -1;
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i]) {
        l = i;
        break;
      }
    }
    for (int i = n - 1; i >= 0; i--) {
      if (a[i] != b[i]) {
        r = i;
        break;
      }
    }
    if(l==-1) {
      System.out.println("yes");
      System.out.println("1 1");
      return;
    }
    reverse(a, l, r);
    for (int i = 0; i < n; i++) {
      if (a[i] != b[i]) {
        System.out.println("no");
        return;
      }
    }
    System.out.println("yes");
    System.out.println((l + 1) + " " + (r + 1));
    sc.close();
  }
}
