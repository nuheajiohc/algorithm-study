import java.io.*;
import java.util.*;

public class Solution {

    static int N, M, cnt;
    static List<Integer>[] adj;
    static boolean[] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            cnt = 0;
            vis = new boolean[N+1];
            adj = new ArrayList[N+1];
            for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

            while(M-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }

            for(int i=1; i<=N; i++){
                if(vis[i]) continue;
                cnt ++;
                dfs(i);
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");

        }
        System.out.println(sb);
    }

    static void dfs(int idx){
        vis[idx] = true;
        for(int next : adj[idx]){
            if(vis[next]) continue;
            dfs(next);
        }
    }
}
