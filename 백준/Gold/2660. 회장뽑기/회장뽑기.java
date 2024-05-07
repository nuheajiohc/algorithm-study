import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static List<Integer>[] member;
    private static int[] vis;
    private static StringBuilder sb = new StringBuilder();
    private static int[] candidate; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        member = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            member[i] = new ArrayList<>();
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1) break;
            member[a].add(b);
            member[b].add(a);
        }

        candidate = new int[N+1];
        int minScore=50;
        for(int i=1; i<=N; i++){
            candidate[i] = bfs(i);
            minScore = Math.min(minScore,candidate[i]);

        }
        
        int count=0;
        for(int i=1; i<=N; i++){
            if(minScore == candidate[i]){
                count++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(minScore+" "+count);
        System.out.println(sb.toString());
    }

    public static int bfs(int i){
        vis = new int[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        vis[i]=1;
        int score=0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            score = Math.max(score, vis[cur]);
            for(int next : member[cur]){
                if(vis[next]>0) continue;
                vis[next] = vis[cur]+1;
                queue.offer(next);
            }
        }
        return score-1;
    }
}
