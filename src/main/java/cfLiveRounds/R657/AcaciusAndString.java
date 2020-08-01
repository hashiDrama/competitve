package cfLiveRounds.R657;

import java.util.Scanner;

public class AcaciusAndString {
  
  //*********************This is someone els's solution and was RIGHT*****************
  public static String str = "abacaba";
  public static char[] c = "abacaba".toCharArray();
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int t = input.nextInt();
      while(t-- != 0){
          int n = input.nextInt();
          input.nextLine();
          String s = input.nextLine();
          solve(n,s);
      }
  }

  static void solve(int n, String s){
      if(checker(s) == 1){
          System.out.println("Yes\n"+s.replace('?', 'x'));
          return;
      }
      else if(checker(s) == 2){
          System.out.println("No");
          return;
      }
      for(int i = 0; i < n-6; i++){
          char[] ch = s.toCharArray();
          String out = "";
          for(int j = 0; j < 7; j++){
              if(ch[i+j] == c[j] || ch[i+j] == '?')
                  ch[i+j] = c[j];
              else
                  break;
              if(j==6){
                  for(int z = 0; z < n; z++){
                      if(ch[z] == '?')
                          out += "z";
                      else out += ch[z] + "";
                  }
                  if(checker(out) == 1){
                      System.out.println("Yes\n"+out);
                      return;
                  }
                  break;
              }
          }
      }
      System.out.println("No");
  }

  static int checker(String s){
      if(s.contains(str)){
          if(s.indexOf(str) == s.lastIndexOf(str))
              return 1;
          else return 2;
      }
      return 0;
  }

  
// *******************************This is solution submitted by me and was WRONG*****************************
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int T = sc.nextInt();
//    String str = "abacaba";
//    for (int t = 0; t < T; t++) {
//      int n = sc.nextInt();
//      String s = sc.next();
//      int count = 0;
//
//      if (str.equals(s)) {
//        System.out.println("Yes");
//        System.out.println(s);
//        continue;
//      }
//      for (int i = 0; i <= n - 7; i++) {
//        if (str.equals(s.substring(i, i + 7))) {
//          count++;
//        }
//      }
//      if (count > 1) {
//        System.out.println("No");
//        continue;
//      } else if (count == 1) {
//        s = s.replace('?', 'd');
//        System.out.println("Yes");
//        System.out.println(s);
//        continue;
//      } else if (s.contains("?")) {
//        boolean found = false;
//        int i;
//        for (i = 0; i <= n - 7; i++) {
//          if ((s.charAt(i) == 'a' || s.charAt(i) == '?')
//              && (s.charAt(i + 1) == 'b' || s.charAt(i + 1) == '?')
//              && (s.charAt(i + 2) == 'a' || s.charAt(i + 2) == '?')
//              && (s.charAt(i + 3) == 'c' || s.charAt(i + 3) == '?')
//              && (s.charAt(i + 4) == 'a' || s.charAt(i + 4) == '?')
//              && (s.charAt(i + 5) == 'b' || s.charAt(i + 5) == '?')
//              && (s.charAt(i + 6) == 'a' || s.charAt(i + 6) == '?')) {
//            found = true;
//            break;
//          }
//        }
//        if (found) {
//          StringBuilder sb = new StringBuilder();
//          sb.append(s.substring(0, i).replace('?', 'd'));
//          sb.append(str);
//          for (int j = i + 7; j < n; j++) {
//            if (s.charAt(j) == '?') {
//              sb.append('d');
//            } else {
//              sb.append(s.charAt(j));
//            }
//          }
//          int cn = 0;
//          for (int l = 0; l <= n - 7; l++) {
//            if (str.equals(sb.substring(l, l + 7))) {
//              cn++;
//            }
//          }
//          if (cn > 1) {
//            System.out.println("No");
//            continue;
//          }
//          System.out.println("Yes");
//          System.out.println(sb.toString());
//        } else {
//          System.out.println("No");
//        }
//      } else {
//        System.out.println("No");
//      }
//    }
//    sc.close();
//  }
}
