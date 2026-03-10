import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]>[] adj;
    static int[] dist1, dist2, dist3;
    static PriorityQueue<int[]> pq;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        st.nextToken();
        N = (int) st.nval;

        st.nextToken();
        M = (int) st.nval;

        pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        while (M-- > 0) {
            st.nextToken();
            int u = (int) st.nval;

            st.nextToken();
            int v = (int) st.nval;

            st.nextToken();
            int e = (int) st.nval;

            adj[u].add(new int[]{v, e});
            adj[v].add(new int[]{u, e});
        }

        st.nextToken();
        int mid1 = (int) st.nval;

        st.nextToken();
        int mid2 = (int) st.nval;

        dist1 = new int[N + 1];
        Arrays.fill(dist1, INF);

        dijkstra(1, N, dist1);

        if (dist1[mid1] == INF || dist1[mid2] == INF || dist1[N] == INF) {
            System.out.println(-1);
            return;
        }

        dist2 = new int[N + 1];
        Arrays.fill(dist2, INF);
        dijkstra(mid1, N, dist2);

        dist3 = new int[N + 1];
        Arrays.fill(dist3, INF);
        dijkstra(mid2, N, dist3);

        int cand1 = dist1[mid1] + dist2[mid2] + dist3[N];
        int cand2 = dist1[mid2] + dist3[mid1] + dist2[N];

        System.out.println(Math.min(cand1, cand2));
    }

    static void dijkstra(int start, int end, int[] dist) {
        pq.clear();
        pq.offer(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int e = cur[1];

            if (dist[u] != e) continue;

            for (int[] next : adj[u]) {
                int nu = next[0];
                int ne = next[1];

                if (dist[nu] <= dist[u] + ne) continue;

                dist[nu] = dist[u] + ne;
                pq.offer(new int[]{nu, dist[nu]});
            }
        }
    }
}