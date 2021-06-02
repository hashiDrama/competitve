package amazon.onlineasseement;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {

  private static int[] minimalHeaviestSet(int[] arr) {
    int n = arr.length;
    Arrays.sort(arr);
    int[] prefix = new int[n];
    int[] suffix = new int[n];
    prefix[0] = arr[0];
    for (int i = 1; i < n; i++)
      prefix[i] += prefix[i - 1] + arr[i];
    suffix[n - 1] = arr[n - 1];
    for (int i = n - 2; i >= 0; i--)
      suffix[i] += suffix[i + 1] + arr[i];

    int si = n - 1, pi = 0;
    while (si > pi) {
      if (suffix[si] > prefix[pi])
        pi++;
      else
        si--;
    }
    int[] ans = new int[n - si];
    for (int i = si; i < n; i++)
      ans[i - si] = arr[i];
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    int[] ans = minimalHeaviestSet(arr);
    for (int i : ans)
      System.out.println(i);
  }
}
