package amazon.onlineasseement;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem3 {

  private static int[] noOfItems_1(String s, int[] st, int[] end) {
    Set<Integer> set = new HashSet<Integer>();
    int count, total, n = st.length;
    char[] c = s.toCharArray();
    for (int i = 0; i < n; i++) {
      count = 0;
      total = 0;
      for (int j = st[i] - 1; j <= end[i] - 1; j++) {
        if (c[j] == '|') {
          if (count > 0)
            total += count;
          count = 0;
        } else
          count++;
      }
      set.add(total);
    }
    int[] arr = new int[set.size()];
    int idx = 0;
    for (Integer i : set) {
      arr[idx++] = i;
    }
    return arr;
  }

  private static int[] noOfItems(String s, int[] st, int[] end) {
    int n = st.length;
    int[] val = new int[s.length()];
    char[] a = s.toCharArray();
    int idx = 0, count = 0, prev = 0;
    for (char c : a) {
      if (c == '|') {
        prev += count;
        val[idx] = prev;
        count = 0;
      } else {
        count++;
        val[idx] = prev;
      }
      idx++;
    }

    int[] ans = new int[n];
    int items;
    for (int i = 0; i < n; i++) {
      items = val[end[i] - 1] - val[st[i] - 1];
      ans[i] = items;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int n = sc.nextInt();
    int[] st = new int[n];
    int[] end = new int[n];
    for (int i = 0; i < n; i++)
      st[i] = sc.nextInt();
    for (int i = 0; i < n; i++)
      end[i] = sc.nextInt();
    int[] ans = noOfItems_1(s, st, end);
    for (int i : ans)
      System.out.println(i);
  }
}
