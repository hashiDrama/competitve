package gfg.array.rotations;

public class Problem10 {

  /*
   * Reversal algorithm for left rotation of array
   */
  public static int[] rotate(int[] a, int d) {
    if(d > a.length)
      d = d%a.length;
    a = reverse(a, 0, d-1);
    a = reverse(a, d, a.length-1);
    a = reverse(a, 0, a.length-1);
    return a;
  }
  
  public static int[] reverse(int[] a, int l, int r) {
    int temp;
    if(r-l == 1) {
      temp = a[l];
      a[l] = a[r];
      a[r] = temp;
      return a;
    }
    for(int i=l; i<=(r+l)/2; i++) {
      temp = a[i];
      a[i] = a[r+l-i];
      a[r+l-i] = temp;
    }
    return a;
  }
  
  public static void print(int[] a) {
    for(int i=0; i<a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println("");
  }
  
  public static void main(String args[]) {
    
    int a[] = new int[] {1, 2, 3, 4, 5};
    a = rotate(a, 1);
    print(a);
  }
  
}
