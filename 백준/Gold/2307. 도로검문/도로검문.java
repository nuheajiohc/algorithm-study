import java.io.*;
import java.util.*;

public class Main {

    static int N, M, minTime;
    static List<int[]>[] adj;
    static int[] time;
    static int[] parent;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
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
        }

        minTime = dijkstra(-1, -1);

        List<int[]> shortestPath = new ArrayList<>();
        int cur = N;
        while(cur != 1){
            int p = parent[cur];
            shortestPath.add(new int[]{p, cur});
            cur = p;
        }
        
        int delay = 0;
        for(int[] edge : shortestPath){
            int tmp = dijkstra(edge[0], edge[1]);
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

    static int dijkstra(int blockU, int blockV){
        pq.clear();
        Arrays.fill(time, Integer.MAX_VALUE);

        time[1] = 0;
        pq.offer(new int[]{1, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int e = cur[1];
            if(u==N) return time[N];
            if(time[u] != e) continue;
            
            for(int[] next : adj[u]){
                int nu = next[0];
                int ne = next[1];
                if ((u == blockU && nu == blockV) || (u == blockV && nu == blockU)) continue;
                if(time[nu] <= time[u] + ne) continue;
                
                if(blockU==-1){
                    parent[nu] = u;
                }

                time[nu] = time[u] + ne;
                pq.offer(new int[]{nu, time[nu]});
            }
        }

        return time[N];
    }
}
