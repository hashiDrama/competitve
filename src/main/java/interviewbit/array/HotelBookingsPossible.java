/*
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 */
package interviewbit.array;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelBookingsPossible {

  public static boolean hotel(ArrayList<Integer> a, ArrayList<Integer> d, int k) {
    a = (ArrayList) a.stream().map(i -> i = i * 2 + 1).collect(Collectors.toList());
    d = (ArrayList) d.stream().map(i -> i = i * 2).collect(Collectors.toList());
    a.forEach(i -> System.out.print(i + ", "));
    System.out.println();
    d.forEach(i -> System.out.print(i + ", "));
    System.out.println();
    a.addAll(d);
    a.sort(null);
    int count = 0;
    for (Integer i : a) {
      if (i % 2 != 0)
        count++;
      else
        count--;
      if (count > k)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> d = new ArrayList<>();
    for (int i = 0; i < n; i++)
      a.add(sc.nextInt());
    for (int i = 0; i < n; i++)
      d.add(sc.nextInt());

    boolean ans = hotel(a, d, k);
    System.out.println(ans ? 1 : 0);
    sc.close();
  }
}
