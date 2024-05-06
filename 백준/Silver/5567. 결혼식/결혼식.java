import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, count;
    private static List<Integer>[] friends;
    private static int[] vis;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        friends = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            friends[i] = new ArrayList<>();
        }
        
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        vis = new int[N+1];
        count=0;
        bfs();
        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1] = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: friends[cur]){
                if(vis[next]>0) continue;
                vis[next] = vis[cur]+1;
                queue.offer(next);
            }
        }

        for(int i=1; i<=N; i++){
            if(vis[i]>1 && vis[i]<=3){
                count++;
            }
        }
    }
}
