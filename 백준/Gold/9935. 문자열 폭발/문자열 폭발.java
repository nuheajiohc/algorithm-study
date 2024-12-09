import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String target = br.readLine();

    Deque<Character> stack = new ArrayDeque<>();

    for(int i=0; i<str1.length(); i++){
      stack.offerLast(str1.charAt(i));
      
      if(stack.size()>=target.length() && stack.peekLast() ==target.charAt(target.length()-1)){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j< target.length(); j++){
          sb.append(stack.pollLast());
        }
        sb.reverse();
        for(int j=0; j<target.length(); j++){
          if(sb.charAt(j)!=target.charAt(j)){
            for(int k=0; k<target.length(); k++){
              stack.offerLast(sb.charAt(k));
            }
            break;
          }
        }
      }
    }
    if(stack.isEmpty()){
      System.out.println("FRULA");
    }else{
      StringBuilder sb = new StringBuilder();
      while(!stack.isEmpty()){
        sb.append(stack.pollFirst());
      }
      System.out.println(sb);
    }
  }
}
