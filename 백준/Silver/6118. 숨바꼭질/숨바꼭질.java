import java.io.*;
import java.util.*;

public class Main {

    private static int N,M,maxDistance;
    private static List<Integer>[] adj;
    private static int[] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(maxDistance==vis[i]){
                sb.append(i).append(" ");
                break;
            }
        }
        sb.append(maxDistance).append(" ");
        int count=0;
        for(int i=1; i<=N; i++){
            if(maxDistance==vis[i]){
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
    }

    public static void bfs(){
        vis = new int[N+1];
        Arrays.fill(vis,-1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1] = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: adj[cur]){
                if(vis[next]>-1) continue;
                vis[next] = vis[cur] + 1;
                maxDistance = vis[next];
                queue.offer(next);
            }
        }
    }
}
