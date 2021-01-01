//@formatter:off
/*
 * Freecodecamp youtube lecture on DP -> https://www.youtube.com/watch?v=oBt53YbR9Kk&list=LL&index=1&t=1s
 * 
 * Memoization recipe:
 * 1. Make it work
 *  - visualize the problem as a tree
 *  - implement the tree using recursion
 *  - test it
 * 2. Make it efficient
 *  - add a memo object
 *  - add a base case to return memo values
 *  - store return values into memo
 */
//@formatter:on
package notes.dp;

public class DpNotes {

  int dp  =10;
  public static void main(String[] args) {

    String url = "http://www.youtube.com/watch?v=ClkQA2Lb_iE";
    System.out.println(url.indexOf('/'));
    String[] elements = url.split("/");
    for(String s : elements) {
      System.out.println(s);
    }
    System.out.println(elements[2]);
  }
}
 