/**
 * Leetcode- Wordbreak2; link -> https://leetcode.com/problems/word-break-ii/
 */
package leetcode.dp.numbertower;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordBreak2 {

  private static Map<Integer, List<String>> mem;

  public static List<String> wordBreak(String s, List<String> wordDict) {
    mem = new HashMap<>();
    return wordBreakHelper(0, s, wordDict);
  }

  private static List<String> wordBreakHelper(int index, String s, List<String> wordDict) {
    if (index == s.length())
      return Arrays.asList("");
    if (mem.containsKey(index))
      return mem.get(index);
    List<String> result = new ArrayList<>();

    for (String w : wordDict) {
      if (s.indexOf(w, index) == index) {
        List<String> suffixWays =
            wordBreakHelper(index + w.length(), s, wordDict);
        for (String str : suffixWays) {
          if (str.equals(""))
            result.add(w);
          else
            result.add(w + " " + str);
        }
      }
    }
    mem.put(index, result);
    return result;
  }

  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String s = sc.nextLine();
//    int n = sc.nextInt();
//    sc.nextLine();
//    List<String> wordDict = new ArrayList<>();
//    for (int i = 0; i < n; i++) {
//      wordDict.add(sc.next());
//    }
//    List<String> ans = wordBreak(s, wordDict);
//    ans.forEach(System.out::println);
//    sc.close();
    BigInteger b = new BigInteger("12");
    BigInteger c = null;
    System.out.println(c.add(b));
  }
}
