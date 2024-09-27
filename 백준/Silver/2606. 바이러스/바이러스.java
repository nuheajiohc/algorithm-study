import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    List<Integer>[] adj = new ArrayList[N+1];
    for(int i=0; i<=N; i++){
      adj[i] = new ArrayList<>();
    }

    for(int i=0; i<M; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj[a].add(b);
      adj[b].add(a);
    }

    int count=0;
    boolean[] vis = new boolean[N+1];
    vis[1] = true;
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(1);
    while(!queue.isEmpty()){
      int cur = queue.poll();
      for(int next : adj[cur]){
        if(vis[next]) continue;
        vis[next] =true;
        queue.offer(next);
        count++;
      }
    }
    System.out.println(count);
  }
}
