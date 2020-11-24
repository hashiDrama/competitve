/*
 * uva-122; link ->
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=58
 */

package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreesOnTheLevel {

  static class Node {
    int val;
    Node left, right;

    public Node(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  static class Tree {
    Node root;

    public Tree() {
      this.root = new Node(-1);
    }

    public Tree(int val) {
      this.root = new Node(val);
    }
  }

  static List<Integer> levelOrderTraversal(Tree tree) {
    List<Integer> bfs = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();
    q.add(tree.root);
    while (!q.isEmpty()) {
      Node curr = q.poll();
      bfs.add(curr.val);
      if (curr.left != null && !q.contains(curr.left))
        q.add(curr.left);
      if (curr.right != null && !q.contains(curr.right))
        q.add(curr.right);
    }
    return bfs;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Tree tree = new Tree();
    while (true) {
      String data = sc.nextLine();
      if (data.trim().isEmpty()) {
        break;
      }
      String[] line = data.split(" ");
      boolean invalidTree = false;
      for (String s : line) {
        if (invalidTree) {
          System.out.println("not complete");
          tree = new Tree();
          break;
        }
        if (s.length() == 2) {
          List<Integer> bfs = levelOrderTraversal(tree);
          List<Integer> invalidValues =
              bfs.parallelStream().filter(i -> i == -1).collect(Collectors.toList());
          if (invalidValues.size() > 0) {
            System.out.println("not complete");
          } else {
            for (int i = 0; i < bfs.size() - 1; i++) {
              System.out.print(bfs.get(i) + " ");
            }
            System.out.println(bfs.get(bfs.size() - 1));
          }
          tree = new Tree();
          break;
        }
        String[] nodeStr = s.split(",");
        int val = Integer.parseInt(nodeStr[0].substring(1));
        String nodePath = nodeStr[1].substring(0, nodeStr[1].length() - 1);
        if (nodePath.length() == 0) {
          if (tree.root.val != -1) {
            invalidTree = true;
            continue;
          }
          tree.root.val = val;
          continue;
        }
        Node node = tree.root;
        for (char c : nodePath.toCharArray()) {
          switch (c) {
            case 'L':
              if (node.left == null) {
                node.left = new Node(-1);
              }
              node = node.left;
              break;
            case 'R':
              if (node.right == null) {
                node.right = new Node(-1);
              }
              node = node.right;
              break;
            default:
              break;
          }
        }
        if (node.val != -1) {
          invalidTree = true;
        } else {
          node.val = val;
        }
      }
    }
    sc.close();
  }
}
