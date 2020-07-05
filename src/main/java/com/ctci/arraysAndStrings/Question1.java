package com.ctci.arraysAndStrings;

import java.util.Hashtable;

public class Question1 {

  /**
   * This is O(N^2) lookup for unique char string
   * 
   * @param str
   * @return
   */
  private static boolean isUnique(String str) {
    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);
      int nextIndexOfCurrentChar = str.indexOf(currentChar, i + 1);
      if (nextIndexOfCurrentChar != -1) {
        return false;
      }
    }
    return true;
  }

  /**
   * This is O(N) lookup for unique char string in average case. But it will go to O(N^2) in worst
   * case when all the string chars are stored at the same index in hash table
   * 
   * @param str
   * @return
   */
  private static boolean isUniqueUsingHashTable(String str) {
    Hashtable<Character, Integer> charHashTable = new Hashtable<>();
    for (int i = 0; i < str.length(); i++) {
      charHashTable.put(str.charAt(i), 1);
    }
    if (charHashTable.size() != str.length())
      return false;
    return true;
  }

  public static void main(String[] args) {
    String str1 = "This is not a unique string.";
    String str2 = "Am uniqe.";
    System.out.println("str1 is unique: " + isUniqueUsingHashTable(str1));
    System.out.println("str2 is unique: " + isUniqueUsingHashTable(str2));
  }
}

