import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,V;
    private static List<Integer>[] adj;
    private static boolean[] vis;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
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
        vis = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        vis = new boolean[N+1];
        bfs();
        System.out.println(sb);
    }

    public static void dfs(int cur){
        vis[cur]=true;
        sb.append(cur).append(" ");
        for(int next : adj[cur]){
            if(vis[next]) continue;
            dfs(next);
        }
    }

    public static void bfs(){
        vis[V]=true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(V);
        sb.append(V).append(" ");
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adj[cur]){
                if(vis[next]) continue;
                vis[next] = true;
                q.offer(next);
                sb.append(next).append(" ");
            }
        }
    }
}
