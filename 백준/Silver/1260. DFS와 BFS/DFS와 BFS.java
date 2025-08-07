import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,V;
    private static List<Integer>[] adj;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i=1; i<N+1; i++){
            Collections.sort(adj[i]);
        }

        boolean[] vis = new boolean[N+1];
        dfs(V, vis);
        sb.append("\n");
        vis = new boolean[N+1];
        bfs(vis);
        System.out.println(sb.toString());
    }

    public static void dfs(int n, boolean[] vis){
        vis[n]=true;
        sb.append(n).append(" ");
        for(int v : adj[n]){
            if(vis[v]) continue;
            dfs(v, vis);
        }
    }

    public static void bfs(boolean[] vis){
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(V);
        vis[V]=true;
        sb.append(V).append(" ");
        while(!q.isEmpty()){
            int value = q.poll();
            for(int v : adj[value]){
                if(vis[v]) continue;
                sb.append(v).append(" ");
                vis[v]=true;
                q.offer(v);
            }
        }
    }
}
