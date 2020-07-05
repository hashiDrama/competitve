package com.ctci.arraysAndStrings;

import java.util.HashSet;

public class Question17_22 {

  public static String convertMe(String w, String r, HashSet<String> dictionary) {
    for (int i = 0; i < w.length(); i++) {
      for (int j = 0; j < w.length(); j++) {
        if (w.charAt(j) != r.charAt(j)) {
          char c = r.charAt(j);
          String w1 = (j != w.length()-1) ? (w.substring(0, j) + c + w.substring(j + 1, w.length())) : 
            (w.substring(0, j) + c);
          if (dictionary.contains(w1)) {
            w = w1;
            continue;
          }
        }
      }
      if(w.equals(r)) {
        return w;
      }
    }
    return w;
  }
  
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();
    set.add("LAMP");
    set.add("LAME");
    set.add("LIME");
    set.add("LIKE");
    set.add("LIMP");
    String w = "DAMP";
    String r = "LIKE";
    w = convertMe(w, r, set);
    System.out.println(w.equals(r));
  }
}
