import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();

    Deque<Character> stack = new ArrayDeque<>();
    int count=0;
    int idx=0;
    while(idx<line.length()-1){
      char c = line.charAt(idx);
      if(c=='(' && line.charAt(idx+1)==')'){
        count += stack.size();
        idx+=2;
      }else if(c=='(' && line.charAt(idx+1)=='('){
        stack.offerLast(c);
        idx++;
      }else{
        stack.pollLast();
        count++;
        idx++;
      }
    }
    System.out.println(count + stack.size());
  }
}
