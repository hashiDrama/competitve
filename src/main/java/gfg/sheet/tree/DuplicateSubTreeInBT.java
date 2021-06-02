/*
 * https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1
 */
package gfg.sheet.tree;

import java.util.Scanner;

public class DuplicateSubTreeInBT {
  
  private String name, email;

  int dupSub(Node node) {
    if(node == null)
      return 0;
     return hasDuplicateSubTree(node.left, node.right) ? 1 : 0;
  }

  private static boolean hasDuplicateSubTree(Node n1, Node n2) {
    if (n1 == null && n2 == null)
      return true;
    if ((n1 == null && n2 != null) || (n1 != null && n2 == null))
      return false;
    if (n1.data == n2.data) {
      return hasDuplicateSubTree(n1.left, n2.left) && hasDuplicateSubTree(n1.right, n2.right);
    } else {
      return hasDuplicateSubTree(n1, n2.left) || hasDuplicateSubTree(n1, n2.right)
          || hasDuplicateSubTree(n1.left, n2) || hasDuplicateSubTree(n1.right, n2);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = "0.0.0.0.";
    System.out.println(s.endsWith("."));
    String[] d = s.split("\\.");
    System.out.println(d.length);
  }
}


class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}
