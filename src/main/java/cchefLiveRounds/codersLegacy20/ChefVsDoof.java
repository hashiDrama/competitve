package cchefLiveRounds.codersLegacy20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChefVsDoof {

  public static void main(String[] args) throws Exception{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(reader.readLine());
    for(int t=0; t<T; t++) {
      int n = Integer.parseInt(reader.readLine());
      int[] a = new int[n];
      String arrayData = reader.readLine();
      String[] arrayD = arrayData.split(" ");
      int j=0;
      for(String d : arrayD) {
        a[j++] = Integer.parseInt(d);
      }
      boolean evenFound = false;
      for(int i=0; i<n; i++) {
        if(a[i] % 2 == 0) {
          evenFound = true;
          break;
        }
      }
      if(evenFound) {
        System.out.println("NO");
      }else {
        System.out.println("YES");
      }
    }
    reader.close();
  }
}
