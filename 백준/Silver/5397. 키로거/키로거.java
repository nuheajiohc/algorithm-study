import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    while(T-->0){
      String line = br.readLine();
      Deque<Character> queue1 = new ArrayDeque<>();
      Deque<Character> queue2 = new ArrayDeque<>();
      for(int i = 0; i < line.length(); i++){
        char c = line.charAt(i);
        if(c == '<'){
          if(!queue1.isEmpty()){
            queue2.offerFirst(queue1.pollLast());
          }
        }else if(c== '>'){
          if(!queue2.isEmpty()){
            queue1.offerLast(queue2.pollFirst());
          }
        }else if(c=='-'){
          queue1.pollLast();
        }else{
          queue1.offerLast(line.charAt(i));
        }
      }

      while(!queue1.isEmpty()){
        sb.append(queue1.pollFirst());
      }
      while(!queue2.isEmpty()){
        sb.append(queue2.pollFirst());
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}
