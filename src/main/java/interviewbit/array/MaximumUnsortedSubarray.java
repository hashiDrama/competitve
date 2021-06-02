/*
 * https://www.interviewbit.com/problems/maximum-unsorted-subarray/
 */
package interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumUnsortedSubarray {

  public static ArrayList<Integer> subUnsort(ArrayList<Integer> a) {
    int n = a.size();
    ArrayList<Integer> b = new ArrayList<>();
    b.addAll(a);
    a.sort(null);
    int i=-1,j=-1;
    for(int k=0; k<n; k++)
        if(a.get(k) != b.get(k)){
            i=k;
            break;
        }
    for(int k=n-1; k>=0; k--)
        if(a.get(k) != b.get(k)){
            j=k;
            break;
        }
    ArrayList<Integer> ans = new ArrayList<>();
    if(i==j)
        ans.add(-1);
    else{
        ans.add(i);
        ans.add(j);
    }
    return ans;
}
  
  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(new Integer[] {1, 2, 3});
    subUnsort(new ArrayList<>(a));
  }
}
