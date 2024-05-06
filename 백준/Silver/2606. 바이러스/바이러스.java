import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,count;
    private static List<Integer>[] computers;
    private static boolean[] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        computers = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            computers[i] = new ArrayList<>();
        }

        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            computers[u].add(v);
            computers[v].add(u);
        }
        vis = new boolean[N+1];
        // bfs();
        vis[1] = true;
        dfs(1);
        System.out.println(count);
    }

    public static void bfs(){

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1]= true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: computers[cur]){
                if(vis[next]) continue;
                vis[next] = true;
                count+=1;
                queue.offer(next);
            }
        }
    }

    public static void dfs(int cur){
        // vis[cur] = true;
        for(int next: computers[cur]){
            if(vis[next]) continue;
            vis[next] = true;
            count++;
            dfs(next);
        }
    }
}
