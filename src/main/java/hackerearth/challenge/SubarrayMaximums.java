/*
 * 
 * You are given an array A of N integers. A subarray of any array is a continuous segment of the
 * original array, of non zero length. You have to answer Q queries of the form L R. The answer to
 * each query is the sum of lengths of all subarrays in A, whose maximum element's value is in the
 * range [L,R], both inclusive
 * 
 * 
 * Input format The first line contains N and Q as above. The second line contains N space separated
 * integers representing the array A. The next Q lines contain two integers L and R each,
 * representing the desired range for the respective queries. Output format For each query, print
 * the required sum of length of subarrays in a new line.
 * 
 * 
 */

package hackerearth.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubarrayMaximums {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] a = new int[n];
    int[] m = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      if(i>0)
        m[i] = Math.max(m[i-1], a[i]);
      else
        m[i] = a[i];
    }
    while (q-- > 0) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int ans = 0, max;
      for (int i = 0; i < n; i++) {
        max = a[i];
        if (m[i] >= l && m[i] <= r) {
          ans += (int) ((i+1)*(i+2)/2);
        }
//        for (int j = i; j < n; j++) {
//          max = Math.max(max, a[j]);
//          if (max < l || max > r)
//            continue;
//          List<Integer> sa = new ArrayList<>();
//          for (int k = i; k <= j; k++) {
//            sa.add(a[k]);
//          }
//          ans += j-i+1;
//        }
      }
      System.out.println(ans);
    }
    sc.close();
  }
}
