import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    while(N-->0){
      int x = Integer.parseInt(br.readLine());
      if(x==0){
        if(pq.isEmpty()){sb.append(0).append("\n");}
        else sb.append(pq.poll()).append("\n");
      }else{
        pq.offer(x);
      }
    }
    System.out.println(sb);
  }
}
