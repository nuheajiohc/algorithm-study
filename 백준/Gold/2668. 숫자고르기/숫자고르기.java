import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] cycle;
    private static int[] adj;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adj = new int[N+1];

        for(int i=1; i<=N; i++){
            int a = Integer.parseInt(br.readLine());
            adj[i]=a;
        }

        cycle = new boolean[N+1];

        for(int i=1; i<=N; i++){
            if(cycle[i]) continue;
            int[] vis = new int[N+1];
            dfs(vis, i);
        }

        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=1; i<=N; i++){
            if(cycle[i]){
                count++;
                sb.append(i).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }

    public static void dfs(int[] vis, int cur){
        if(vis[cur]==1){
            check(cur);
            return;
        }
        vis[cur]++;
        dfs(vis, adj[cur]);
    }

    public static void check(int cur){
        if(cycle[cur]) return;
        cycle[cur]=true;
        check(adj[cur]);
    }
}
