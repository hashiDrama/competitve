package juniorSheet.cfB;

import java.util.Scanner;

public class BearAndFindingCriminals {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int count = 0;
    int limit = Math.max(a, n - a);
    a--;
    for (int i = 1; i <= limit; i++) {
      if ((a + i) < n && arr[a + i] == 1 && (a - i) >= 0 && arr[a - i] == 1) {
        count += 2;
      } else if ((a + i) < n && (a - i) < 0) {
        count += arr[a + i];
      } else if ((a - i) >= 0 && (a + i) >= n) {
        count += arr[a - i];
      }
    }
    if (arr[a] == 1) {
      count++;
    }
    System.out.println(count);
    sc.close();
  }
}
