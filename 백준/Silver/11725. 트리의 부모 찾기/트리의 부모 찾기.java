import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N =Integer.parseInt(br.readLine());

    List<Integer>[] adj = new ArrayList[N+1];
    for(int i=1; i<=N; i++){
      adj[i] = new ArrayList<>();
    }

    int[] family = new int[N+1];

    for(int i=1; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj[a].add(b);
      adj[b].add(a);
    }

    Queue<Integer> q = new ArrayDeque<>();
    q.offer(1);
    boolean[] vis = new boolean[N+1];
    vis[1]= true;

    while(!q.isEmpty()){
      int cur = q.poll();
      for(int next: adj[cur]){
        if(vis[next]) continue;
        vis[next] = true;
        q.offer(next);
        family[next]= cur;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=2; i<=N; i++){
      sb.append(family[i]).append("\n");
    }
    System.out.println(sb);
  }
}
