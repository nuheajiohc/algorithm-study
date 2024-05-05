import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,V;
    private static boolean[] vis;
    private static List<Integer>[] adj;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            adj[v].add(u);
            adj[u].add(v);
        }
        for(int i=1; i<=N; i++){
            Collections.sort(adj[i]);
        }

        vis = new boolean[N+1];
        vis[V] =true;
        sb.append(V).append(" ");
        dfs1(V);
        // dfs2();
        sb.append("\n");

        vis = new boolean[N+1];
        bfs();
        System.out.println(sb.toString());
    }

    public static void dfs1(int cur){
        // vis[cur] = true;
        // sb.append(cur).append(" ");
        for(int next:adj[cur]){
            if(vis[next]) continue;
            vis[next] =true;
            sb.append(next).append(" ");
            dfs1(next);
        }
    }

    public static void dfs2(){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(V);
        while(!stack.isEmpty()){
            int cur = stack.pollLast();
            if(vis[cur]) continue;
            vis[cur] = true;
            sb.append(cur).append(" ");
            for(int i=adj[cur].size()-1; i>=0; i--){
                if(vis[adj[cur].get(i)]) continue;
                stack.offer(adj[cur].get(i));
            }
        }
    }

    public static void bfs(){
        vis[V] = true;
        sb.append(V).append(" ");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(V);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: adj[cur]){
                if(vis[next]) continue;
                sb.append(next).append(" ");
                vis[next]=true;
                queue.offer(next);
            }
        }
    }   
}
