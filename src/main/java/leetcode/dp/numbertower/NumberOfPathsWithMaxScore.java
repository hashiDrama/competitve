/*
 * Leetcode-Number of paths with max score; link ->
 * https://leetcode.com/problems/number-of-paths-with-max-score/
 */
package leetcode.dp.numbertower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfPathsWithMaxScore {

  public static int[] pathsWithMaxScore(List<String> board) {
    int mod = 1000000007;
    int n = board.size();
    int[][] dp = new int[n + 1][n + 1];
    int[][] count = new int[n + 1][n + 1];
    board.set(0, "0" + board.get(0).substring(1, board.get(0).length()));
    board.set(n - 1, board.get(n-1).substring(0,board.get(n-1).length()-1) + "0");
    count[n - 1][n - 1] = 1;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (board.get(i).charAt(j) == 'X')
          continue;
        int max = Math.max(dp[i + 1][j], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
        dp[i][j] = board.get(i).charAt(j) - '0' + max;
        if (dp[i + 1][j] == max)
          count[i][j] = (count[i][j] + count[i + 1][j]) % mod;
        if (dp[i][j + 1] == max)
          count[i][j] = (count[i][j] + count[i][j + 1]) % mod;
        if (dp[i + 1][j + 1] == max)
          count[i][j] = (count[i][j] + count[i + 1][j + 1]) % mod;
      }
    }
    return new int[] {count[0][0] != 0 ? dp[0][0] : 0, count[0][0]};
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    List<String> board = new ArrayList<>();
    for (int i = 0; i < n; i++)
      board.add(sc.nextLine());
    int[] path = pathsWithMaxScore(board);
    System.out.println();
    for (int i : path)
      System.out.print(i + " ");
    sc.close();
  }
}
