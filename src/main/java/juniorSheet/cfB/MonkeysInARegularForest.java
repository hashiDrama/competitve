
  /*
    
    
    
   Sample input 
    A B D E C C D
    F F W D D D D
    P W E W W W W
    %
    a A b B c d E t
    a a a a a c c t
    e f g h c a a t
    
    Sample output
    1 2 3 4 5 5 3
    6 6 7 3 3 3 3
    8 7 9 7 7 7 7
    %
    1 2 3 4 5 6 7 8
    1 1 1 1 1 5 5 8
    9 10 11 12 5 1 1 8
    %
    
    
   */


package juniorSheet.cfB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MonkeysInARegularForest {
  
  static int n, m;
  static boolean vis[][];
  static Character ip[][];
  static int op[][];
  
  
  static boolean valid(int r, int c) {
    return r>=0 && c>=0 && r < n && c < m;
  }
  
  static void send(int r, int c, int count, char currElem) {
    if(!valid(r, c))
      return;
    if(vis[r][c] || ip[r][c] != currElem)
      return;
    vis[r][c] = true;
    op[r][c] = count;
    send(r-1, c-1, count, currElem);
    send(r-1, c, count, currElem);
    send(r-1, c+1, count, currElem);
    send(r, c-1, count, currElem);
    send(r, c+1, count, currElem);
    send(r+1, c-1, count, currElem);
    send(r+1, c, count, currElem);
    send(r+1, c+1, count, currElem);
    
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()) {
      List<String> in = new ArrayList<>();
      String next = sc.nextLine();
      while(!next.equals("%")) {
        next = next.replace(" ", "");
        in.add(next);
        next = sc.nextLine();
      }
      n = in.size();
      m = in.get(0).length();
      ip = new Character[n][m];
      for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
          ip[i][j] = in.get(i).charAt(j);
        }
      }
      vis = new boolean[n][m];
      op = new int[n][m];
      int count = 1;
      for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
          if(!vis[i][j]) {
            send(i, j, count, ip[i][j]);
            count++;
          }
        }
      }
      for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
          System.out.printf("%2s ", op[i][j]);
        }
        System.out.println();
      }
    }
  }
}
