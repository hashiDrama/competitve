/*
 * CF-546-C; link -> https://codeforces.com/problemset/problem/546/C
 */
package a2oj.dfsbfsdijkstra;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SoldierAndCards {

  private static boolean queuesEqual(Deque<Integer> tq1, Deque<Integer> tq2) {
    if (tq1.size() != tq2.size())
      return false;
    Deque<Integer> q1 = new LinkedList<>();
    Deque<Integer> q2 = new LinkedList<>();
    q1.addAll(tq1);
    q2.addAll(tq2);
    while (!q1.isEmpty()) {
      if (!q1.poll().equals(q2.poll()))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int n1 = sc.nextInt();
    Deque<Integer> q1 = new LinkedList<>();
    for (int i = 0; i < n1; i++)
      q1.addLast(sc.nextInt());
    int n2 = sc.nextInt();
    Deque<Integer> q2 = new LinkedList<>();
    for (int i = 0; i < n2; i++)
      q2.addLast(sc.nextInt());
    int top1, top2;
    Deque<Integer> tq1 = new LinkedList<>();
    Deque<Integer> tq2 = new LinkedList<>();
    tq1.addAll(q1);
    tq2.addAll(q2);
    int count = 0;
    boolean repeated = false;
    while (!tq1.isEmpty() && !tq2.isEmpty()) {
      count++;
      top1 = tq1.pollFirst();
      top2 = tq2.pollFirst();
      if (top1 > top2) {
        tq1.addLast(top2);
        tq1.addLast(top1);
      } else {
        tq2.addLast(top1);
        tq2.addLast(top2);
      }
      if (queuesEqual(tq1, q1) && queuesEqual(tq2, q2)) {
        repeated = true;
        break;
      }
    }
    if (repeated) {
      System.out.println(-1);
    } else {
      if (tq1.isEmpty())
        System.out.println(count + " 2");
      else if (tq2.isEmpty())
        System.out.println(count + " 1");
    }
    sc.close();
  }
}
