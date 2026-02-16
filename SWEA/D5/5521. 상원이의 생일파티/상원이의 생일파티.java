import java.io.*;
import java.util.*;

public class Solution {

    static int N,M;
    static List<Integer>[] adj;
    static int[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N+1];
            for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

            while(M-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }

            
            sb.append("#").append(tc).append(" ").append(bfs(1)).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int idx){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);

        visited = new int[N+1];
        Arrays.fill(visited, -1);
        visited[idx] = 0;

        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : adj[cur]){
                if(visited[next]>=0) continue;
                if(visited[cur]+1>2) continue;
                visited[next] = visited[cur] + 1;
                cnt++;
                q.offer(next);
            }
        }
        return cnt;
    }
}
