import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static List<int[]>[] adj;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[u].add(new int[] {v,e});
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int minCost = dijkstra(start, end);
		
		System.out.println(minCost);
	}
	
	static int dijkstra(int s, int e) {
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[s] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.offer(new int[] {s, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int u = cur[0];
			int w = cur[1];
			if(u==e) {
				break;
			}
			if(dist[u] != w) continue;
			
			for(int[] next : adj[u]) {
				int nu = next[0];
				int nw = next[1];
				
				if(dist[nu] <= dist[u] + nw) continue;
				dist[nu] = dist[u] + nw;
				pq.offer(new int[] {nu, dist[nu]});
			}
		}
		
		return dist[e];
	}

}
