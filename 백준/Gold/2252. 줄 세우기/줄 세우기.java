import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] adj;
    static int[] degree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        degree = new int[N+1];

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            degree[b]++;
        }

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(degree[i]!=0) continue;
            queue.offer(i);
            ans.add(i);
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : adj[cur]){
                if(--degree[next]!=0) continue;
                queue.offer(next);
                ans.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : ans){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
