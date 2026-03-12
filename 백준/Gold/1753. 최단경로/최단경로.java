import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E;
	static List<int[]>[] adj;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V+1];
		for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();
		
		while(E-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new int[] {v, w});
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			sb.append(dist[i]==INF ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	
	static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
		
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int u = now[0];
			int w = now[1];
			
			if(dist[u] != w) continue;
			
			for(int[] next : adj[u]) {
				int nu = next[0];
				int nw = next[1];
				
				if(dist[nu] <= dist[u] + nw) continue;
				dist[nu] = dist[u] + nw;
				pq.offer(new int[] {nu, dist[nu]});
			}
		}
	}

}
