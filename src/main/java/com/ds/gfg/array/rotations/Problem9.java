package com.ds.gfg.array.rotations;

public class Problem9 {

  public static int findRotationsResult(int[] a) {
    if (a.length == 1)
      return 0;
    return findRotations(a, 0, a.length - 1);
  }

  public static int findRotations(int[] a, int l, int r) {
    if (l > r)
      return 0;
    if (l == r)
      return l;
    int mid = (r + l) / 2;
    if (mid > l && a[mid] < a[mid - 1])
      return mid;
    if (mid < r && a[mid] > a[mid + 1])
      return mid + 1;
    if (a[mid] < a[r])
      return findRotations(a, l, mid - 1);
    return findRotations(a, mid + 1, r);
  }

  static int countRotations(int arr[], int low, int high) {
    // This condition is needed to handle
    // the case when array is not rotated
    // at all
    if (high < low)
      return 0;

    // If there is only one element left
    if (high == low)
      return low;

    // Find mid
    // /*(low + high)/2;*/
    int mid = low + (high - low) / 2;

    // Check if element (mid+1) is minimum
    // element. Consider the cases like
    // {3, 4, 5, 1, 2}
    if (mid < high && arr[mid + 1] < arr[mid])
      return (mid + 1);

    // Check if mid itself is minimum element
    if (mid > low && arr[mid] < arr[mid - 1])
      return mid;

    // Decide whether we need to go to left
    // half or right half
    if (arr[high] > arr[mid])
      return countRotations(arr, low, mid - 1);

    return countRotations(arr, mid + 1, high);
  }
  
  static int countRotations(int arr[], int n) 
  { 
      // We basically find index of minimum 
      // element 
      int min = arr[0], min_index = 0; 
      for (int i = 0; i < n; i++) 
      { 
          if (min > arr[i]) 
          { 
              min = arr[i]; 
              min_index = i; 
          } 
      }  
      return min_index; 
  }

  public static void main(String[] args) {
    int[] a = new int[] {1, 2, 3, 4, 5};
    //System.out.println(findRotationsResult(a));
    //System.out.println(countRotations(a, 0, a.length-1));
    System.out.println(countRotations(a, a.length));
  }
}
