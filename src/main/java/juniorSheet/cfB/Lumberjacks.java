package juniorSheet.cfB;

import java.util.Scanner;

public class Lumberjacks {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] x = new int[n];
    int[] h = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
      h[i] = sc.nextInt();
    }

    int prev = Integer.MIN_VALUE;
    int count = 1;
    for (int i = 0; i < n - 1; i++) {
      // check left
      if ((x[i] - h[i]) > prev) {
        count++;
        prev = x[i];
      } else if ((x[i] + h[i]) < x[i + 1]) {
        count++;
        prev = x[i] + h[i];
      } else {
        prev = x[i];
      }
    }
    System.out.println(count);
    sc.close();
  }
}
