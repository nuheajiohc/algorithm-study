import java.io.*;
import java.util.*;

public class Solution {

    static int N,M;
    static List<Integer>[] adj;
    static boolean[] vis;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=TC; tc++){
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            adj = new ArrayList[N+1];
            for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

            while(M-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
            }

            arr = new int[N];
            for(int i=1; i<=N; i++){
                vis = new boolean[N+1];
                dfs(i);

                int cnt=0;
                for(int j=1; j<=N; j++){
                    if(vis[j]) cnt++;
                }
                arr[i-1] = cnt;
            }

            Arrays.sort(arr);
            int ans = 0;
            for(int i=0; i<N; i++){
                int cnt = 0;
                for(int j=0; j<N;j++){
                    if(arr[i]>=arr[j]) cnt++;
                }

                if(cnt==arr[i]+1) ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
    
    static void dfs(int idx){
        for(int v : adj[idx]){
            if(vis[v]) continue;
            vis[v] = true;
            dfs(v);
        }
    }
}
