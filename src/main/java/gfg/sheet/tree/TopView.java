/*
 * https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1#
 */
package gfg.sheet.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

  public static void main(String[] args) throws IOException {
    // Scanner sc=new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      Queue<Node> q = new LinkedList<>();

      int n = Integer.parseInt(br.readLine());
      String input[] = br.readLine().trim().split(" ");

      Node root = null;
      int j = 0;
      while (n > 0) {
        int a1 = Integer.parseInt(input[j]);
        int a2 = Integer.parseInt(input[j + 1]);
        char lr = input[j + 2].charAt(0);
        j += 3;

        if (root == null) {
          root = new Node(a1);
          q.add(root);
        }

        Node pick = q.peek();

        q.remove();

        if (lr == 'L') {
          pick.left = new Node(a2);
          q.add(pick.left);
        }
        a1 = Integer.parseInt(input[j]);
        a2 = Integer.parseInt(input[j + 1]);
        lr = input[j + 2].charAt(0);
        j += 3;

        if (lr == 'R') {
          pick.right = new Node(a2);
          q.add(pick.right);
        }

        n -= 2;
      }
      new View().topView(root);
      System.out.println();
      t--;
    }
  }
}


class View {
  private static Map<Integer, Pair> map;

  static void topView(Node node) {
    if (node == null)
      return;
    ArrayList<Integer> list = getTopViewList(node);
    for (int i = 0; i < list.size() - 1; i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println(list.get(list.size() - 1));
  }

  static ArrayList<Integer> getTopViewList(Node node) {
    if (node == null)
      return new ArrayList<>();
    map = new TreeMap<>();
    solve(node, 0, 0);

    ArrayList<Integer> ans = new ArrayList<>();
    for (Integer hDist : map.keySet()) {
      ans.add(map.get(hDist).data);
    }
    return ans;
  }

  private static void solve(Node node, int hDist, int level) {
    if (node == null)
      return;
    Pair p = new Pair(node.data, level);
    if (!map.containsKey(hDist)) {
      map.put(hDist, p);
    } else if (level < map.get(hDist).level) {
      map.put(hDist, p);
    }
    solve(node.left, hDist - 1, level + 1);
    solve(node.right, hDist + 1, level + 1);
  }
}


class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}


class Pair {
  int data;
  int level;

  public Pair() {}

  public Pair(int data, int level) {
    this.data = data;
    this.level = level;
  }
}
