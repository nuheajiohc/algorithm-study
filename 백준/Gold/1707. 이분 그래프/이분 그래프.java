import java.io.*;
import java.util.*;

public class Main {

    private static List<Integer>[] adj;
    private static int[] vis;
    private static int v,e;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            adj = new ArrayList[v+1];
            vis = new int[v+1];
            Arrays.fill(vis,-1);
            for(int i=1; i<=v; i++) adj[i] = new ArrayList<>();

            while(e-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }

            bfs();
            check();
        }
        System.out.println(sb.toString());
    }

    public static void bfs(){
        for(int i=1; i<=v; i++){
            if(vis[i]>-1)continue;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            vis[i]=0;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next : adj[cur]){
                    if(vis[next]>-1) continue;
                    vis[next] = (vis[cur]+1)%2;
                    queue.offer(next);
                }
            }
        }
    }

    public static void check(){
        for(int i=1; i<=v; i++){
            int cur = vis[i];
            for(int next: adj[i]){
                if(cur==vis[next]){
                    sb.append("NO").append("\n");
                    return;
                }
            }
        }
        sb.append("YES").append("\n");
    }
}
