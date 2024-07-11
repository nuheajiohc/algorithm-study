import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static List<Integer>[] adj;
    private static int[] deg;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        deg = new int[N+1];
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            deg[b]++;
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            if(deg[i]==0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int next : adj[cur]){
                deg[next]--;
                if(deg[next]==0){
                    queue.offer(next);
                }
            }
        }   
        System.out.println(sb.toString());
    }
}
