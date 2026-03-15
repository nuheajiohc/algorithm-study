import java.io.*;
import java.util.*;

public class Main {

    static List<Edge>[] adj;
    static int V, E;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V+1];
        for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();

        while(E-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        int mstWeight = prim(1);
        System.out.println(mstWeight);
    }

    static int prim(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];

        pq.offer(new Edge(start, 0));
        
        int mstWeight = 0;
        int connected = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;
            mstWeight += now.weight;
            connected++;

            if(connected == V) break;

            for(Edge next : adj[now.to]){
                if(visited[next.to]) continue;
                pq.offer(next);
            }
        }
        return mstWeight;
    }

    static class Edge implements Comparable<Edge> {

        int to, weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
