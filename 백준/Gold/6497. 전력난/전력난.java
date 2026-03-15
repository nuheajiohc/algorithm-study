import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<Edge>[] adj;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;

            int totalCost = 0;

            adj = new ArrayList[N];
            for(int i=0; i<N; i++) adj[i] = new ArrayList<>();

            while(M-->0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                adj[u].add(new Edge(v, w));
                adj[v].add(new Edge(u, w));
                totalCost += w;
            }

            int minWeight = prim(0);
            sb.append(totalCost - minWeight).append("\n");
        }
        System.out.println(sb);
    }

    static int prim(int start){
        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int minWeight = 0;
        int connected = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(visited[now.to]) continue;
            visited[now.to] = true;
            minWeight += now.weight;
            connected++;

            if(connected == N) break;

            for(Edge next : adj[now.to]){
                if(!visited[next.to]) pq.offer(next);
            }
        }
        return minWeight;
    }

    static class Edge implements Comparable<Edge>{
        int to, weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
}
