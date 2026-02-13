import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer>[] adj;
    static boolean[] vis;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n+1];
        vis = new boolean[n+1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();

        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        System.out.println(dfs(1));
    }

    static int dfs(int idx){
        vis[idx] = true;
        int cnt = 0;
        for(int next : adj[idx]){
            if(vis[next]) continue;
            cnt += 1 + dfs(next);
        }
        return cnt;
    }
}
