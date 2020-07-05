package juniorSheet.cfA;

import java.util.Scanner;

public class CarmichaelNumber {

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
  
  static long gcd(long a, long b) {
    return b==0 ? a : gcd(b, a%b);
  }
  
  static boolean isCarmichael(long n) {
    if(n%2==0) return false;
    long a;
    boolean factorFound = false;
    long s = (long) Math.sqrt(n);
    a = 2L;
    while(a<n) {
      if(a>s && !factorFound) {
        return false;
      }
      if(gcd(a, n) > 1) {
        factorFound = true;
      }else if(findexp(a, n-1, n) != 1){
        return false;
      }
      a++;
    }
    return true;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    while(true) {
     int n = sc.nextInt();
     if(n==0) break;
     if(isCarmichael(n)) System.out.println("The number " + n + " is a Carmichael number.");
     else System.out.println("" + n + " is normal.");
    }
    sc.close();
  }
}
