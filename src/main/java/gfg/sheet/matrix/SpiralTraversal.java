/*
 * 
 */
package gfg.sheet.matrix;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SpiralTraversal {

  static boolean isValid(char c, Stack<Character> data) {
    if (data.isEmpty())
      return true;
    StringBuilder sb = new StringBuilder();
    switch (c) {
      case '(':
        while (data.peek() != ')') {
          sb.append(data.pop());
        }
        data.pop();
        break;
      case '{':
        while (data.peek() != '}') {
          sb.append(data.pop());
        }
        data.pop();
        break;
      case '[':
        while (data.peek() != ']') {
          sb.append(data.pop());
        }
        data.pop();
        break;
      default:
        break;
    }
    
    return solve(sb.toString());
  }

  static boolean solve(String s) {
    Stack<Character> data = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
        data.add(s.charAt(i));
      else {
         if(!isValid(s.charAt(i), data)) {
           return false;
         }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);  
    String s = sc.next();
    System.out.println(solve(s));
  }

  private static long get() {
    int a = 1;
    long max = 0;
    max = a;
    return a;
  }

  static ArrayList<Integer> spirallyTraverse(int m[][], int r, int c) {
    // code here
    ArrayList<Integer> result = new ArrayList<>();
    int i = 0, j = 0, d = 0;
    // d=0 -> R
    // d=1 -> D
    // d=2 -> L
    // d=3 -> U
    boolean[][] vis = new boolean[r][c];
    while (true) {
      if (d == 0) {
        while (i < r && j < c && !vis[i][j]) {
          result.add(m[i][j]);
          j++;
        }
        d++;
        i++;
        j--;
        continue;
      }
      if (d == 1) {
        while (i < r && j < c && !vis[i][j]) {
          result.add(m[i][j]);
          i++;
        }
        d++;
        i--;
        j++;
        continue;
      }
      if (d == 2) {
        while (i < r && j >= 0 && !vis[i][j]) {
          result.add(m[i][j]);
          j--;
        }
        d++;
        i--;
        j++;
        continue;
      }
      if (d == 3) {
        while (i >= 0 && j < c && !vis[i][j]) {
          result.add(m[i][j]);
          i--;
        }
        d = 0;
        i++;
        j++;
        continue;
      }
    }

  }
}
