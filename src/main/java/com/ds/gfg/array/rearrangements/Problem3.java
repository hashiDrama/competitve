package com.ds.gfg.array.rearrangements;

public class Problem3 {
  
  public static int[] mergeSort(int[] a, int l, int r) {
    if(l<r) {
      int m = (r+l)/2;
      a = mergeSort(a, l, m);
      a = mergeSort(a, m+1, r);
      a = merge(a, l, m, r);
    }
    return a;
  }
  
  public static int[] merge(int[] a, int l, int m, int r) {
    int n1 = m-l+1;
    int n2 = r-m;
    int a1[] = new int[n1];
    int a2[] = new int[n2];
    for(int i=0; i<n1;i++) {
      a1[i] = a[i+l];
    }
    for(int i=0; i<n2;i++) {
      a2[i] = a[i+m+1];
    }
    int i=0, j=0, k=l;
    while(i<n1 && j<n2) {
      if(a1[i] < a2[j]) {
        a[k] = a1[i];
        i++;
      }
      else {
        a[k] = a2[j];
        j++;
      }
      k++;
    }
    while(i<n1) {
      a[k] = a1[i];
      i++;
      k++;
    }
    while(j<n2) {
      a[k] = a2[j];
      j++;
      k++;
    }
    return a;
  }

  public static int[] rearrange(int[] a) {
    int c[];
    c = a.clone();
    c = mergeSort(c, 0, c.length-1);
    int n = c.length;
    int j;
    if(n%2 == 0) {
      j = n-1;
      for(int i=n-1; i>0 ; i -= 2) {
        a[i] = c[j];
        j--;
      }
      j=0;
      for(int i=n-2;i>=0; i-=2) {
        a[i] = c[j];
        j++;
      }
    }
    else {
      j=0;
      for(int i=n-1; i>0 ; i -= 2) {
        a[i] = c[j];
        j++;
      }
      j=n-1;
      for(int i=n-2;i>=0; i-=2) {
        a[i] = c[j];
        j--;
      }
    }
    return a;
  }
  public static void main(String[] args) {
    int a[] = new int[] {4, 2, 1, 5, 6, 3};
    //a = mergeSort(a, 0, a.length-1);
    for(int i=0;i<a.length;i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println("");
    a = rearrange(a);
    for(int i=0;i<a.length;i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println("");
  }
}
