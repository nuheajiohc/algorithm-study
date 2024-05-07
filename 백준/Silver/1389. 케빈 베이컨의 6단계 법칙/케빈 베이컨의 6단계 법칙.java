import java.io.*;
import java.util.*;

public class Main {

    private static int N,M;
    private static List<Integer>[] relationship;
    private static int[] vis;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        relationship = new ArrayList[N+1];
        for(int i=1; i<=N; i++) relationship[i] = new ArrayList<>();

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relationship[a].add(b);
            relationship[b].add(a);
        }

        int kb=5000;
        int idx=0;
        for(int i=1; i<=N; i++){
            int temp = bfs(i);
            if(kb>temp){
                kb=temp;
                idx=i;
            }
        }
        System.out.println(idx);
    }

    public static int bfs(int i){
        vis = new int[N+1];
        Arrays.fill(vis,-1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        vis[i]=0;
        int tempKb=0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next: relationship[cur]){
                if(vis[next]>-1) continue;
                vis[next] = vis[cur]+1;
                tempKb+=vis[next];
                queue.add(next);
            }
        }
        return tempKb;
    }
}
