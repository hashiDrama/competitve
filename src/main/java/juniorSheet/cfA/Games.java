package juniorSheet.cfA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Games {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Map<String, Integer>> teamList = new ArrayList<>();
    for(int i=0; i<n; i++) {
      Map<String, Integer> team = new HashMap<>();
      team.put("Host", sc.nextInt());
      team.put("Guest", sc.nextInt());
      teamList.add(team);
    }
    int count=0;
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        if(j != i && teamList.get(i).get("Host").equals(teamList.get(j).get("Guest"))) {
          count++;
        }
      }
    }
    System.out.println(count);
    sc.close();
  }
}
