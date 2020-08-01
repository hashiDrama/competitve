package cfLiveRounds.R656;

import java.util.Scanner;

public class ThreePairwiseMax {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for(int t=0; t<T; t++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();
      
      if(x!=y && x!=z && y!=z) {
        System.out.println("NO");
        continue;
      }
      if((x>y && x>z) || (y>x && y>z) || (z>x && z>y)) {
        System.out.println("NO");
        continue;
      }
      System.out.println("YES");
      if(x == z) {
        System.out.println(y + " " + y + " " + x);
        continue;
      }
      if(y == z) {
        System.out.println(x + " " + x + " " + y);
        continue;
      }
      if(x == y) {
        System.out.println(z + " " + z + " " + x);
      }
    }
    sc.close();
  }
}
