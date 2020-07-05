package juniorSheet.cfA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamOlympiad {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Integer> s1 = new ArrayList<>();
    List<Integer> s2 = new ArrayList<>();
    List<Integer> s3 = new ArrayList<>();
    for(int i=0; i<n; i++) {
      int student = sc.nextInt();
      if(student==1) {s1.add(i);}
      else if(student==2) {s2.add(i);}
      else {s3.add(i);}
    }
    int i=0;
    if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {System.out.println(0);}
    else {
        System.out.println(Math.min(Math.min(s1.size(),s2.size()), s3.size()));
      while(i < s1.size() && i < s2.size() && i < s3.size()) {
        System.out.println("" + (s1.get(i)+1) + " " + (s2.get(i)+1) + " " + (s3.get(i)+1));
        i++;
      }
    }
    sc.close();
  }
}
