/*
 * https://arena.topcoder.com/index.html#/u/coding/18535/16828/1
 */
package topcoder.rookiesrm3;

import java.util.Scanner;

public class TakeStones {

  public String result(int stonePile, int maxStones) {
    if ((stonePile == maxStones + 1) || (stonePile % (maxStones + 1) == 0))
      return "LOSE";
    return "WIN";
  }
}
