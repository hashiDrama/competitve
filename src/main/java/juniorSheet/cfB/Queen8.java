package juniorSheet.cfB;

import java.util.Scanner;

public class Queen8 {

  static int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
  static int[] output = new int[8];
  static boolean[] used = new boolean[8];
  static int pointer = 0;
  static int col = 1;
  static boolean flg = true;
  static int count = 1;

  static boolean check() {
    if (output[pointer] != col)
      return false;

    for (int i = 0; i < 8; i++)
      for (int j = i + 1; j < 8; j++)
        if (output[i] == output[j] || (Math.abs(i - j)) == (Math.abs(output[i] - output[j])))
          return false;
    return true;
  }

  static void go(int[] input, int[] output, boolean[] used, int index) {

    if (index == output.length) {
      if (check()) {
        if ((count + "").length() > 1)
          System.out.print(count++ + " ");
        else
          System.out.print(" " + count++ + " ");
        for (int i = 0; i < output.length - 1; i++)
          System.out.print(output[i] + " ");

        System.out.println(output[output.length - 1]);
      }
      return;
    }

    for (int i = 0; i < 8; i++) {
      if (!used[i]) {

        used[i] = true;
        output[index] = input[i];
        go(input, output, used, index + 1);
        used[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int T = s.nextInt();

    while (T-- > 0) {
      col = s.nextInt();
      pointer = s.nextInt() - 1;

      System.out.println("SOLN COLUMN");
      System.out.println(" # 1 2 3 4 5 6 7 8");
      System.out.println();

      go(input, output, used, 0);

      if (T != 0)
        System.out.println();

      count = 1;
    }

  }

}
