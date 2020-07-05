package juniorSheet.cfA;

import java.util.Scanner;

public class Pangrams {

  static void func(String s) {
    char[] c = new char[128];
    for(char ch : s.toLowerCase().toCharArray()) {
      c[ch]++;
    }
    for(int i='a'; i<='z'; i++) {
      if(c[i]==0) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    String s = sc.next();
    func(s);
    sc.close();
  }
}
