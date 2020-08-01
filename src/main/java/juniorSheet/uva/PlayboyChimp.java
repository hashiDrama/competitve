package juniorSheet.uva;

import java.util.Scanner;

public class PlayboyChimp {

  static int findLast(long[] arr, long h) {
    int start = 0, end = arr.length - 1, mid = 0;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (arr[mid] <= h)
        start = mid + 1;
      else if (arr[mid] > h)
        end = mid - 1;
    }
    if (start >= arr.length) {
      return -1;
    }
    return start;
  }

  static int findFirst(long[] arr, long h) {
    int start = 0, end = arr.length - 1, mid;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (arr[mid] < h)
        start = mid + 1;
      else if (arr[mid] >= h)
        end = mid - 1;
    }
    if (end < 0) {
      return -1;
    }
    return end;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] ladyChimps = new long[n];
    for (int i = 0; i < n; i++) {
      ladyChimps[i] = sc.nextInt();
    }
    long q = sc.nextInt();
    long height;
    for (long i = 0; i < q; i++) {
      height = sc.nextLong();
      int first = findFirst(ladyChimps, height);
      int second = findLast(ladyChimps, height);

      if (first == -1) {
        System.out.print("X ");
      } else {
        System.out.print(ladyChimps[first] + " ");
      }
      if (second == -1) {
        System.out.println("X");
      } else {
        System.out.println(ladyChimps[second]);
      }
    }
    sc.close();
  }
}
