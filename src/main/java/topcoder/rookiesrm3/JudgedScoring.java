/*
 * https://arena.topcoder.com/index.html#/u/coding/18535/16829/1
 */
package topcoder.rookiesrm3;

import java.util.Arrays;

public class JudgedScoring {

  public int overallScore(int[] scores) {
    Arrays.sort(scores);
    int n = scores.length;
    int sum = 0;
    for (int i = 1; i < n - 1; i++)
      sum += scores[i];
    return sum;
  }
}
