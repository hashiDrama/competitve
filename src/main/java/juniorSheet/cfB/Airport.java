/*
 * https://codeforces.com/contest/218/problem/B
 */
package juniorSheet.cfB;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Airport {

  // Way 1 : Sort
  // public static void main(String[] args) {
  // Scanner sc = new Scanner(System.in);
  // int n = sc.nextInt();
  // int m = sc.nextInt();
  // int[] min = new int[m];
  // int[] max = new int[m];
  // for (int i = 0; i < m; i++) {
  // min[i] = sc.nextInt();
  // max[i] = min[i];
  // }
  // Arrays.sort(min);
  // Arrays.sort(max);
  // int startIdx = 0;
  // int minCost = 0;
  // int rem = n;
  // while (rem > 0) {
  // minCost += min[startIdx]--;
  // if (min[startIdx] == 0)
  // startIdx++;
  // rem--;
  // }
  // int endIdx = m - 1;
  // int maxCost = 0;
  // rem = n;
  // while (rem > 0) {
  // maxCost += max[endIdx]--;
  // Arrays.sort(max);
  // rem--;
  // }
  // System.out.println(maxCost + " " + minCost);
  // sc.close();
  // }

  // Way 2: Priority Queue
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    PriorityQueue<Integer> minpq = new PriorityQueue<>();
    PriorityQueue<Integer> maxpq = new PriorityQueue<>((i1, i2) -> -1 * Integer.compare(i1, i2));
    int ip;
    for (int i = 0; i < m; i++) {
      ip = sc.nextInt();
      minpq.add(ip);
      maxpq.add(ip);
    }
    int min = 0, max = 0, rem = n;
    Integer top;
    while (rem > 0) {
      top = minpq.poll();
      min += top;
      if(top-1 > 0)
        minpq.add(top-1);
      rem--;
    }
    rem = n;
    while (rem > 0) {
      top = maxpq.poll();
      max += top;
      if(top-1 > 0)
        maxpq.add(top-1);
      rem--;
    }
    System.out.println(max + " " + min);
    sc.close();
  }
}
