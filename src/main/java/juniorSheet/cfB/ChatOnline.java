package juniorSheet.cfB;

import java.util.Scanner;

public class ChatOnline {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int p, q, l, r;
    p = sc.nextInt();
    q = sc.nextInt();
    l = sc.nextInt();
    r = sc.nextInt();
    int[] a = new int[p];
    int[] b = new int[q];
    for (int i = 0; i < p; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    int[] c = new int[q];
    int[] d = new int[q];
    for (int i = 0; i < q; i++) {
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }
    int[] ans = new int[r-l+1];
    int count=0;
    for(int i=0; i<p; i++) {
      int min, max;
      for(int j=0; j<q; j++) {
        min = a[i]-d[j];
        max = b[i]-c[j];
        if(max < l || min > r) {
          continue;
        }
        
        for(int k=Math.max(min, l); k<=Math.min(max, r); k++) {
          if(ans[k] == 0) {
            ans[k]++;
            count++;
          }
        }
      }
    }
    System.out.println(count);
    sc.close();
  }
}
