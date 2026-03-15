import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        List<Edge> edges = new ArrayList<>();
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(u == v) continue;

            edges.add(new Edge(u, v, w));
        }

        int minWeight = kruskal(N, edges);
        System.out.println(minWeight);
    }

    static int kruskal(int V, List<Edge> edges){
        Collections.sort(edges);

        int minWeight = 0;
        int connected = 0;

        for(Edge edge : edges) {
            if(union(edge.u, edge.v)) {

                minWeight += edge.w;
                connected++;

                if(connected == V-1) break;

            }
        }
        return minWeight;
    }

    static boolean union(int u, int v){
        u = find(u);
        v = find(v);

        if(u==v) return false;

        if(parent[u] < parent[v]) {
            parent[u] += parent[v];
            parent[v] = u;
        }else{
            parent[v] += parent[u];
            parent[u] = v;
        }
        return true;
    }

    static int find(int u){
        if(parent[u] < 0) return u;

        return parent[u] = find(parent[u]);
    }

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }
    }
}
