/*
 * https://leetcode.com/problems/merge-intervals/
 */
package gfg.sheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  public static int[][] merge(int[][] a) {
    if (a.length <= 1)
      return a;
    Arrays.sort(a, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    List<int[]> result = new ArrayList<>();
    int[] newInterval = a[0];
    result.add(newInterval);
    for (int[] interval : a) {
      if (interval[0] <= newInterval[1]) {
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      } else {
        newInterval = interval;
        result.add(newInterval);
      }
    }
    return result.toArray(new int[result.size()][]);

  }

  public static void main(String[] args) {

  }
}
