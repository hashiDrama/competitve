package cchefLiveRounds.breaking.bugs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Permutation {

  private static int[] a;

  private static void reverse(int s, int e) {
    int temp;
    while (s < e) {
      temp = a[s];
      a[s] = a[e];
      a[e] = temp;
      s++;
      e--;
    }
  }

  private static boolean check() {
    for (int i = 0; i < a.length - 1; i++) {
      if (a[i] > a[i + 1])
        return false;
    }
    return true;
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null || line.isEmpty())
      return;
    int n = Integer.parseInt(line);
    a = new int[n];
    line = br.readLine();
    String[] arr = line.split(" ");
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(arr[i]);
    int s = -1, e = -1;
    for (int i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        int j = -1;
        for (j = i + 1; j < n; j++) {
          if (j != n - 1 && a[j] < a[j + 1]) {
            break;
          }
        }
        if (j != -1) {
          if (j == n)
            j = n - 1;
          reverse(i, j);
          if (check()) {
            s = i;
            e = j;
          }
          break;
        }
      }
    }
    if (s == -1 || e == -1) {
      System.out.println(0 + " " + 0);
    } else
      System.out.println((s + 1) + " " + (e + 1));
  }
}
