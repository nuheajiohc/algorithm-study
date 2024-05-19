import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N+1];
        for(int i=1;i <=N; i++){
            adj[i] = new ArrayList<>();
        }

        int[] deg = new int[N+1];

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            deg[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(deg[i]==0) queue.offer(i);
        }

        StringBuilder sb= new StringBuilder();
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(deg[cur]==0) sb.append(cur).append(" ");
            for(int next: adj[cur]){
                deg[next]--;
                if(deg[next]==0) queue.offer(next);
            }
        }

        System.out.println(sb.toString());
    }
}
