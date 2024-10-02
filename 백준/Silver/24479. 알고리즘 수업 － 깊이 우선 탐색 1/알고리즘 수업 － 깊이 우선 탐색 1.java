import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  private static int N,M,R;
  private static List<Integer>[] adj;
  private static int[] vis;
  private static int count=1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    vis = new int[N+1];
    adj = new ArrayList[N+1];
    for(int i=1; i<=N; i++){
      adj[i] = new ArrayList<>();
    }

    while(M-->0){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj[a].add(b);
      adj[b].add(a);
    }

    for(int i=1; i<=N; i++){
      Collections.sort(adj[i]);
    }
    dfs(R);
    StringBuilder sb= new StringBuilder();
    for(int i=1; i<=N; i++){
      sb.append(vis[i]).append("\n");
    }
    System.out.println(sb);
  }

  public static void dfs(int cur){
    vis[cur] =count;
    for(int next : adj[cur]){
      if(vis[next]!=0) continue;
      count++;
      dfs(next);
    }
  }
}
