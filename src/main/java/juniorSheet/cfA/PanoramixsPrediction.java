package juniorSheet.cfA;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PanoramixsPrediction {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    Integer[] a = new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
    List<Integer> primes = Arrays.asList(a);
    if (primes.indexOf(n) + 1 < primes.size() && primes.get(primes.indexOf(n) + 1) == m) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    sc.close();
  }
}
