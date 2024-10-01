import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(br.readLine());
    long A = Integer.parseInt(st.nextToken());
    long B = Integer.parseInt(st.nextToken());

    Map<Long, Integer> map = new HashMap<>();
    Queue<Long> q = new ArrayDeque<>();
    q.offer(A);
    map.put(A,1);
    while(!q.isEmpty()){
      long cur = q.poll();
      if(cur*2<=B){
        map.put(cur*2, map.get(cur)+1);
        if(cur*2 ==B) break;
        q.offer(cur*2);
      }

      if(cur*10+1<=B){
        map.put(cur*10+1, map.get(cur)+1);
        if(cur*10+1 ==B) break;
        q.offer(cur*10+1);
      }
    }
    System.out.println(map.getOrDefault(B, -1));
  }
}
