import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static String father;
    private static ArrayList<Integer>[] adj;
    private static String[][] route;
    private static boolean[] vis;
    private static int[][] dp = new int[5001][5001];
    private static int max;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        father = br.readLine();

        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
        route = new String[N+1][N+1];
        vis = new boolean[N+1];
        vis[1] = true;
        
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            adj[u].add(v);
            adj[v].add(u);
            route[u][v] = c;
            route[v][u] = c;
        }

        DFS(1,"");
        System.out.println(max);
    }

    public static void DFS(int cur, String s){                
        max = Math.max(max,findHappiness(s));
        for(int next : adj[cur]){
            if(vis[next]) continue;
            vis[next] = true;
            DFS(next,s+route[cur][next]);
            vis[next] = false;
        }
    }

    public static int findHappiness(String s){
        int result=0;
        int idx = s.length()-1;
        if(idx==-1) return 0;
        for(int i=1; i<=father.length(); i++){
            if(father.charAt(i-1)==s.charAt(idx)){
                dp[i][idx+1] = dp[i-1][idx]+1;
            }else{
                dp[i][idx+1] = Math.max(dp[i-1][idx+1],dp[i][idx]);
            }
            result = Math.max(result, dp[i][idx+1]);
        }
        return result;
    }
}
