package ctci.arraysAndStrings;

public class Question3 {

  public static String urlify(String s) {
    char[] ca = s.toCharArray();
    char[] ch = new char[ca.length];
    int i=0, j=0;
    
    char c;
    while(i < ca.length && j < ch.length) {
      c = ca[i++];
      if(c == ' ') {
        ch[j++] = '%';
        ch[j++] = '2';
        ch[j++] = '0';
        continue;
      }
      ch[j++] = c;
    }
    return new String(ch);
  }
  
  public static void main(String[] args) {
    String s = "Mr John Smith    ";
    System.out.println(urlify(s));
  }
}
