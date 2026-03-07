import java.io.*;
import java.util.*;

public class Main {

    static int N, M, minTime;
    static List<int[]>[] adj;
    static int[] time;
    static int[][] road;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        road = new int[M+1][2];
        adj = new ArrayList[N+1];
        time = new int[N+1];
        minTime = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[u].add(new int[]{v, e});
            adj[v].add(new int[]{u, e});
            road[i] = new int[]{u, v};
        }

        minTime = dijkstra(0);
        int delay = 0;
        for(int i=1; i<=M; i++){
            int tmp = dijkstra(i);
            if(tmp == Integer.MAX_VALUE) {
                delay = -1;
                break;
            }
            if(delay < tmp-minTime){
                delay = tmp-minTime;
            }
        }

        System.out.println(delay);
    }

    static int dijkstra(int idx){
        Arrays.fill(time, Integer.MAX_VALUE);

        time[1] = 0;
        pq.offer(new int[]{1, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int e = cur[1];
            if(time[u] != e) continue;
            
            for(int[] next : adj[u]){
                int nu = next[0];
                int ne = next[1];
                if(stop(idx, u, nu)) continue;
                if(time[nu] <= time[u] + ne) continue;
                
                time[nu] = time[u] + ne;
                pq.offer(new int[]{nu, time[nu]});
            }
        }

        return time[N];
    }

    static boolean stop(int idx, int u, int v){
        if(road[idx][0]==u && road[idx][1]==v){
            return true;
        }

        if(road[idx][0]==v && road[idx][1]==u) {
            return true;
        }
        return false;
    }
}
