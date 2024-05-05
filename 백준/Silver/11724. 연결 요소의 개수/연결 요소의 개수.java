import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] vis = new int[N+1];
        List<Integer>[] adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }


        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        int count=0;
        for(int i=1; i<=N; i++){
            if(vis[i]==1) continue;
            count++;
            vis[i] = 1;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i);
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next: adj[cur]){
                    if(vis[next]==1) continue;
                    vis[next] = 1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(count);
        
    }
}
