import java.io.*;
import java.util.*;

public class Main {

    static int n, m, t, s, g, h;
    static List<Edge>[] adj;
    static int[] dest;
    static int[] dist;
    static boolean[] isTraced;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(TC-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            adj = new ArrayList[n+1];
            for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();

            while(m-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                adj[a].add(new Edge(b, d));
                adj[b].add(new Edge(a, d));
            }

            dest = new int[t];
            for(int i=0; i<t; i++){
                dest[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(dest);
            dijkstra();

            for(int d : dest){
                if(isTraced[d] && dist[d] != Integer.MAX_VALUE){
                    sb.append(d).append(" ");
                }
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static void dijkstra(){
        dist = new int[n+1];
        isTraced = new boolean[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0, false));
        dist[s] = 0;

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(dist[now.to] != now.weight) continue;

            if(isTraced[now.to] && !now.trace) continue;

            for(Edge next : adj[now.to]){
                int nextWeight = dist[now.to] + next.weight;

                boolean nextTrace = (now.to == g && next.to == h) || 
                    (now.to == h && next.to == g) || 
                    now.trace;

                if(dist[next.to] > nextWeight){
                    isTraced[next.to] = nextTrace;
                    dist[next.to] = nextWeight;
                    pq.offer(new Edge(next.to, nextWeight, nextTrace));
                }else if(dist[next.to] == nextWeight && !isTraced[next.to] && nextTrace){
                    pq.offer(new Edge(next.to, nextWeight, nextTrace));
                    isTraced[next.to] = nextTrace;
                }
            }

        }
    }

    static class Edge implements Comparable<Edge>{
        int to, weight;
        boolean trace;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        Edge(int to, int weight, boolean trace){
            this(to, weight);
            this.trace = trace;
        }

        public int compareTo(Edge o){
            if(this.weight == o.weight) return Boolean.compare(o.trace, this.trace);
            return Integer.compare(this.weight, o.weight);
        }
    }
}