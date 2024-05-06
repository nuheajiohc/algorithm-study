import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, count;
    private static List<Integer>[] friends;
    private static boolean[] vis;

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

        vis = new boolean[N+1];
        count=0;
        bfs();
        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: friends[cur]){
                if(vis[next]) continue;
                vis[next] = true;
                count++;
                if(cur==1) queue.offer(next);
            }
        }
    }
}
