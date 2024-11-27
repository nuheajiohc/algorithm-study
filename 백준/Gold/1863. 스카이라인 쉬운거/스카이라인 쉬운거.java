import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int count=0;
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i=0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      if(y==0){
        stack = new ArrayDeque<>();
        continue;
      }
      while(!stack.isEmpty()){
        if(stack.peekLast()>y){
          stack.pollLast();
        }else break;
      }

      if(stack.isEmpty() || stack.peekLast()<y){
        count++;
        stack.offerLast(y);

      }
    }
    System.out.println(count);
  }
}
