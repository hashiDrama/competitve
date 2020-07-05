package ctci.arraysAndStrings;

import java.util.Arrays;

public class Question2 {

  public static String sort(String s) {
    char[] c = s.toCharArray();
    Arrays.sort(c);
    return new String(c);
  }
  public static boolean checkPermutations(String s, String t) {
    if(s.length() != t.length())
      return false;
    return sort(s).equals(sort(t));
  }
  
  
  public static boolean isPermutation(String s, String t){
    if(s.length() != t.length())
      return false;
    int[] letters = new int[128];
    
    char[] s_array = s.toCharArray();
    
    for(char c : s_array) {
      letters[c]++;
    }
    
    for(int i=0; i<t.length() ; i++) {
      int c = (int)t.charAt(i);
      letters[c]--;
      if(letters[c] < 0) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    String s = "I am a string";
    String t = "a string I am";
    System.out.println("String s and t are permutaions: " + checkPermutations(s, t));
    System.out.println("String s and t are permutaions: " + isPermutation(s, t));
  }
}
