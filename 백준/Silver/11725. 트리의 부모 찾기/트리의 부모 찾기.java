import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] adj;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        adj = new ArrayList[N+1];

        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for(int node=2; node<=N; node++){
            sb.append(parent[node]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int root){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : adj[cur]){
                if(parent[cur] == next) continue;
                queue.offer(next);
                parent[next] = cur;
            }
        }
    }
}