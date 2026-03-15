import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        Arrays.fill(parent, -1);

        List<Edge> edges = new ArrayList<>();
        while(E-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, w));
        }

        int minWeight = kruskal(V, edges);
        System.out.println(minWeight);
    }

    static int kruskal(int V, List<Edge> edges){
        Collections.sort(edges);

        int mstWeight = 0;
        int connected = 0;

        for(Edge edge : edges) {
            if(!union(edge.v, edge.u)) continue;

            mstWeight += edge.w;
            connected++;

            if(connected == V-1) break;
        }

        return mstWeight;
    }

    static int find(int u){
        if(parent[u] < 0) return u;

        return parent[u] = find(parent[u]);
    }

    static boolean union(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v) return false;

        if(parent[u] > parent[v]){
            parent[v] += parent[u];
            parent[u] = v;
        }else{
            parent[u] += parent[v];
            parent[v] = u;
        }
        return true;
    }

    static class Edge implements Comparable<Edge>{

        int v, u, w;

        Edge(int v, int u, int w){
            this.v = v;
            this.u = u;
            this.w = w;
        }

        public int compareTo(Edge o){
            return Integer.compare(w, o.w);
        }
    }
}
