import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      deque.offer(i);
    }

    int min=0;
    st = new StringTokenizer(br.readLine());
    while(st.hasMoreTokens()){
      int cur = Integer.parseInt(st.nextToken());

      Deque<Integer> repl1 = new ArrayDeque<>(deque);
      int count1=0;
      while(true){
        if(cur==repl1.peekFirst()){
          repl1.pollFirst();
          break;
        }
        repl1.offerLast(repl1.pollFirst());
        count1++;
      }

      int count2 =0;
      Deque<Integer> repl2 = new ArrayDeque<>(deque);
      while(true){
        if(cur==repl2.peekFirst()){
          repl2.pollFirst();
          break;
        }
        repl2.offerFirst(repl2.pollLast());
        count2++;
      }
      if(count1 > count2){
        deque = repl2;
        min+=count2;
      }else{
        deque = repl1;
        min+=count1;
      }
    }
    System.out.println(min);
  }
}
