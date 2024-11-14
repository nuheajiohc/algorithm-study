import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<Node>[] adj = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        int[] d = new int[V+1];
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start]=0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(d[cur.vertex]!= cur.weight) continue;

            for(Node next : adj[cur.vertex]){
                if(d[next.vertex]< d[cur.vertex]+next.weight) continue;
                d[next.vertex]=d[cur.vertex]+next.weight;
                pq.add(new Node(next.vertex,d[next.vertex]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            sb.append(d[i]==Integer.MAX_VALUE?"INF":d[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }
}
