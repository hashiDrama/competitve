package gfg.array.rotations;

public class Problem8 {

  public int findMaxSum(int[] a) {
    int r=0,max,arrSum=0, n= a.length;
    for(int i=0;i<a.length;i++) {
      arrSum += a[i];
      r += i*a[i];
    }
    max = r;
    for(int i=1;i<n;i++) {
      r += n*a[i-1] - arrSum;
      if(max < r)
        max = r;
    }
    return max;
  }
}
