import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();

    List<Integer>[] adj = new ArrayList[N+1];
    for(int i=1; i<=N; i++){
      adj[i] = new ArrayList<>();
    }

    while(M-->0){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj[a].add(b);
    }

    int[] vis = new int[N+1];
    Queue<Integer> q = new ArrayDeque<>();
    q.offer(X);
    Arrays.fill(vis, -1);
    vis[X] = 0;
    while(!q.isEmpty()){
      int cur = q.poll();
      for(int next : adj[cur]){
        if(vis[next]>-1) continue;
        vis[next] = vis[cur]+1;
        q.offer(next);
      }
    }

    for(int i=1; i<=N; i++){
      if(vis[i]==K) sb.append(i).append("\n");
    }

    System.out.println(sb.toString().equals("")?-1:sb);
  }
}
