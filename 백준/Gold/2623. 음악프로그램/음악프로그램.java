import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        int[] degree = new int[N+1];
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int prev = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int next = Integer.parseInt(st.nextToken());

                adj[prev].add(next);
                degree[next]++;
                prev = next;
            }
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(degree[i]!=0) continue;
            queue.offer(i);
            ans.add(i);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : adj[cur]){
                if(--degree[next]>0) continue;
                queue.offer(next);
                ans.add(next);
            }
        }

        if(ans.size()<N){
            System.out.println(0);
        }else{
            StringBuilder sb = new StringBuilder();
            for(int num : ans){
                sb.append(num).append("\n");
            }
            System.out.println(sb);
        }
    }
}
