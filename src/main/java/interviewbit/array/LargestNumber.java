/*
 * https://www.interviewbit.com/problems/largest-number/
 */
package interviewbit.array;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestNumber {

  private static int compare(int a, int b) {
    StringBuilder sb1 = new StringBuilder();
    sb1.append(a).append(b);
    StringBuilder sb2 = new StringBuilder();
    sb2.append(b).append(a);
    return new BigInteger(sb1.toString()).compareTo(new BigInteger(sb2.toString()));
  }
  
  private static String solve(int[] a) {
    List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
    list.sort((i1, i2) -> compare(i1, i2));
    Collections.reverse(list);
    String ans = list.stream().map(i -> i.toString()).collect(Collectors.joining(""));
    if(new BigInteger(ans).equals(BigInteger.ZERO))
      return "0";
    else
      return ans;
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  }
}
