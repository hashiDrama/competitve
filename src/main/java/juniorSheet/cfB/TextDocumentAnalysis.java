/*
 * https://codeforces.com/contest/723/problem/B
 */
package juniorSheet.cfB;

import java.util.Scanner;

public class TextDocumentAnalysis {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    char[] c = sc.next().toCharArray();
    int wip = 0, max = 0, len;
    int j;
    for (int i = 0; i < n;) {
      if (c[i] == '(') {
        j = i + 1;
        while (c[j] != ')') {
          len=0;
          while (j < n && c[j] != '_' && c[j] != ')') {
            len++;
            j++;
          }
          if(len > 0) wip++;
          if (c[j] == '_')
            j++;
        }
        j++;
        i = j;
      } else if (c[i] != '_') {
        j = i + 1;
        while (j < n && c[j] != '_' && c[j] != '(' && c[j] != ')') {
          j++;
        }
        max = Math.max(max, j-i);
        i = j;
      } else
        i++;
    }
    System.out.println(max + " " + wip);
    sc.close();
  }
}
