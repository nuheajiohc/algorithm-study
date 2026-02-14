import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++){
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<Integer>[] adj = new ArrayList[V+1];
            for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();

            int[] degree = new int[V+1];

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                degree[b]++;
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for(int i=1; i<=V; i++){
                if(degree[i]==0){
                    queue.offer(i);
                    sb.append(i).append(" ");
                }
            }
            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next : adj[cur]){
                    degree[next]--;
                    if(degree[next]!=0) continue;
                    queue.offer(next);
                    sb.append(next).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
