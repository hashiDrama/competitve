/*
 * TIMUS-1100; link -> https://acm.timus.ru/problem.aspx?space=1&num=1100
 */

package juniorSheet.cfB;

import java.util.Scanner;

public class FinalStandings {

  static class Team implements Comparable<Team> {
    int id;
    int val;

    public Team(int id, int val) {
      this.id = id;
      this.val = val;
    }

    @Override
    public int compareTo(Team o) {
      return this.val < o.val ? -1 : this.val > o.val ? 1 : 0;
    }

    @Override
    public String toString() {
      return this.id + " " + this.val;
    }
  }

  private static void swap(Team[] heap, int i, int j) {
    Team swap = heap[i];
    heap[i] = heap[j];
    heap[j] = swap;
  }

  static void createHeap(Team[] heap, Team[] teams) {
    int i = 0, n = teams.length;
    heap[i] = teams[i];
    i++;
    while (i < n) {
      heap[i] = teams[i];
      int idx = i;
      while (true) {
        if (idx > 0 && heap[idx].val < heap[(idx - 1) / 2].val) {
          swap(heap, idx, (idx - 1) / 2);
          idx = (idx - 1) / 2;
        } else {
          break;
        }
      }
      i++;
    }
  }

  static void balanceHeap(Team[] heap, int n, int i) {
    int min = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && (heap[min].val > heap[l].val))
      min = l;
    if (r < n && (heap[min].val > heap[r].val))
      min = r;
    if (min != i) {
      swap(heap, min, i);
      balanceHeap(heap, n, min);
    }
  }

  static void deleteHeap(Team[] heap) {
    int n = heap.length;
    for (int i = n - 1; i > 0; i--) {
      Team t = heap[0];
      heap[0] = heap[i];
      heap[i] = t;
      balanceHeap(heap, i, 0);
    }
  }

  public static Team[] heapSort(Team[] teams) {
    Team[] minHeap = new Team[teams.length];
    createHeap(minHeap, teams);
    deleteHeap(minHeap);
    return minHeap;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Team[] teams = new Team[n];
    for (int i = 0; i < n; i++) {
      int id = sc.nextInt();
      int val = sc.nextInt();
      teams[i] = new Team(id, val);
    }
    Team[] sortedTeams = heapSort(teams);
    for (Team team : sortedTeams) {
      System.out.println(team);
    }
    sc.close();
  }

}
