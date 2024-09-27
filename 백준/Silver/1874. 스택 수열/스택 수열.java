import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    Deque<Integer> stack = new ArrayDeque<>();

    int count=1;
    for(int i = 0; i < N; i++) {
      int number = Integer.parseInt(br.readLine());
      while(stack.isEmpty() || number > stack.peekLast()){
        stack.offerLast(count);
        count++;
        sb.append("+\n");
      }

      if(stack.peekLast()==number){
        sb.append("-\n");
        stack.pollLast();
      }
    }
    if(stack.isEmpty()){
      System.out.println(sb);
    }else{
      System.out.println("NO");
    }
  }
}
