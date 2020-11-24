package utils;

import java.util.Scanner;

public class Main {

  // Given an array having n distinct integers from 0...n. Find the missing number
  static int getMissingNo(int[] arr, int n) {
    int a = arr[0];
    int b = 0;
    for (int i = 1; i < arr.length; i++)
      a ^= arr[i];
    for (int i = 1; i < n; i++)
      b ^= i;
    return a ^ b;
  }

  // counting bits
  // Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
  // the number of 1's in their binary representation and return them as an array.
  /**
   * Counting Bites: method 1
   */
  static int countBits1(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    return n % 2 == 0 ? countBits1(n / 2) : 1 + countBits1(n / 2);
  }

  /**
   * Counting Bites: method 2
   */
  static void countBits2(int n) {
    int[] count = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      if ((i & 1) == 1) {
        count[i] = 1 + count[i >> 1];
      } else {
        count[i] = count[i >> 1];
      }
      System.out.println("No of 1's in " + i + ": " + count[i]);
    }
  }

  // Maximum Product of Word Lengths
  // Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where
  // the two words do not share common letters. You may assume that each word will contain only
  // lower case letters. If no such two words exist, return 0.
  /**
   * Method: 1; brute force
   */
  static int maxProduct1(String[] words) {
    int max = Integer.MIN_VALUE;
    int n = words.length;
    boolean same = false;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        same = false;
        for (int k = 0; k < words[j].length(); k++) {
          if (words[i].indexOf(words[j].charAt(k)) != -1) {
            same = true;
            break;
          }
        }
        if (!same) {
          int length = words[i].length() * words[j].length();
          max = Math.max(max, length);
        }
      }
    }
    return max;
  }

  /**
   * Method: 2; bit manipulation
   */
  static int maxProduct2(String[] words) {
    int max = Integer.MIN_VALUE;
    int n = words.length;
    int[] iWords = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        char c = words[i].charAt(j);
        iWords[i] |= (1 << 'z' - c);
      }
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if ((iWords[i] & iWords[j]) == 0) {
          max = Math.max(max, (words[i].length() * words[j].length()));
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 9};
    int n = 7;
    // int m = getMissingNo(a, n);
    // System.out.println(m);

    // count bits
    // for(int i=0; i<n; i++) {
    // System.out.println("No of 1's in " + i + " are: " + countBits1(i));
    // }
    // countBits2(n);
//    System.out.println("How many words: ");
//    n = sc.nextInt();
//    String[] words = new String[n];
//    for (int i = 0; i < n; i++) {
//      words[i] = sc.next();
//    }
//    // System.out.println(maxProduct1(words));
//    System.out.println(maxProduct2(words));
    System.out.println(1<<0);
  }
}
