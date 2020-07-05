package gfg.array.rotations;

public class Problem11 {

  public static int findMin(int[] a, int l, int r) {
    if(l>r)
      return 0;
    if(l ==r)
      return a[l];
    int mid = (r+l)/2;
    if(mid > l && a[mid] < a[mid-1])
      return a[mid];
    if(mid < r && a[mid] > a[mid+1])
      return a[mid+1];
    if(a[mid] < a[r])
      return findMin(a, l, mid-1);
    return findMin(a, mid+1, r);
  }
  
  public static void main(String[] args) {
    int a[] = new int[] {4, 5, 6, 1, 2, 3};
    System.out.println(findMin(a, 0, a.length-1));
  }
}
