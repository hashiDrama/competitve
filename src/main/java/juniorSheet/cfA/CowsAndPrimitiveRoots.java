package juniorSheet.cfA;

import java.util.Scanner;

public class CowsAndPrimitiveRoots {

  static long findexp(long a, long p, long n) {
    long b;
    if(p == 0L) {
      return 1;
    } else if(p == 1L) {
      return a%n;
    }
    b = findexp(a, p/2, n);
    b = (b*b)%n;
    if(p%2!=0) b = (b*a)%n;
    return b;
  }
  
  static int getPrimitiveRootsCount(int p) {
    if(p == 2) return 0;
    else if(p == 3) return 1;
    int count = 1;
    for(int i=3; i<p; i++) {
      if(i%2 != 0 && findexp(i, p-2L, p) != 1L) {
        count++;
      }
    }
    return count;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(getPrimitiveRootsCount(n));
    sc.close();
    
  }
}
