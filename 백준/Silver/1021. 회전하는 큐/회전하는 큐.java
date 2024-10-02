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
      int num = Integer.parseInt(st.nextToken());
      int count=0;
      while(deque.peekFirst()!=num){
        deque.offerLast(deque.pollFirst());
        count++;
      }
      deque.pollFirst();
      min += Math.min(count, deque.size()+1-count);
    }
    System.out.println(min);
  }
}
