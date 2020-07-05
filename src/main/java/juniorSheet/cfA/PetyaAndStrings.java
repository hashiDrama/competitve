package juniorSheet.cfA;

import java.util.Scanner;

public class PetyaAndStrings {

  private static int compareStringsLexicographicallyIgnoreCase(String s1, String s2) {
    char[] c1= s1.toLowerCase().toCharArray();
    char[] c2 = s2.toLowerCase().toCharArray();
    int minLength = c1.length < c2.length ? c1.length : c2.length;
    for(int i=0; i<minLength; i++) {
      if(c1[i] != c2[i]) {
        return c1[i] - c2[i] > 0 ? 1 : -1;
      }
    }
    return 0;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();    
    System.out.println(compareStringsLexicographicallyIgnoreCase(s1, s2));
    sc.close();
  }
}
