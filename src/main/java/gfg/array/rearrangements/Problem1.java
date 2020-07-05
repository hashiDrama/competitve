package gfg.array.rearrangements;

public class Problem1 {

  public static int[] rearrange(int[] a) {
    int temp;
    for(int i=0; i<a.length;) {
      if(a[i] >= 0 && a[i] != i) {
        temp = a[i];
        a[i] = a[a[i]];
        a[temp] = temp;
      }
      else
        i++;
    }
    return a;
  }
  
  public static void main(String[] args) {
    int[] a = new int[] {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
    a = rearrange(a);
    for(int i=0;i<a.length;i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println("");
  }
}
