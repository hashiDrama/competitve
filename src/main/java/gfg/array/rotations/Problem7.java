package gfg.array.rotations;

public class Problem7 {

  public static int findMaxSum(int[] a) {
    int r=0, max, arrSum=0, n= a.length;
    for(int i=0;i<a.length;i++) {
      arrSum += a[i];
      r += i*a[i];
    }
    max = r;
    for(int i=1;i<a.length;i++) {
      r += arrSum - n * a[n-i];
      if(max < r)
        max = r;
    }
    return max;
  }
  
  public static void main(String[] args) {
    int[] a = new int[] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(findMaxSum(a));
  }
}
