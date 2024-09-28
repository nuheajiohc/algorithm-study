import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<Integer>[] adj = new ArrayList[N+1];

    for(int i=1; i<=N; i++){
      adj[i] =  new ArrayList<>();
    }

    for(int i=1; i<=M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj[a].add(b);
      adj[b].add(a);
    }

    boolean[] vis = new boolean[N+1];

    int count=0;
    for(int i=1; i<=N; i++){
      if(vis[i]) continue;
      count++;
      Deque<Integer> q = new ArrayDeque<>();
      vis[i] =true;
      q.offer(i);

      while(!q.isEmpty()){
        int cur = q.poll();
        for(int next : adj[cur]){
          if(vis[next]) continue;
          vis[next] = true;
          q.offer(next);
        }
      }
    }
    System.out.println(count);
  }
}
