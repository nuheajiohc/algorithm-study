import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, X;
	static List<Edge>[] adj, reverse;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
		
		reverse = new ArrayList[N+1];
		for(int i=0; i<=N; i++) reverse[i] = new ArrayList<>();
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Edge(v, w));
			reverse[v].add(new Edge(u, w));
		}
		
		
		int[] fromX = dijkstra(X, adj);
		int[] toX = dijkstra(X, reverse);
		
		int time = 0;
		for(int i=1; i<=N; i++) {
			time = Math.max(time, fromX[i] + toX[i]);
		}
		
		System.out.println(time);
	}
	
	static int[] dijkstra(int start, List<Edge>[] graph) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.weight != dist[now.to]) continue;
			
			for(Edge next : graph[now.to]) {
				if(dist[next.to] <= dist[now.to] + next.weight) continue;
				dist[next.to] = dist[now.to] + next.weight;
				pq.offer(new Edge(next.to, dist[next.to]));
			}
		}
		
		return dist;
	}
	
	static class Edge implements Comparable<Edge> {
		int to, weight;
		
		Edge(int to, int w){
			this.to = to;
			this.weight = w;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}
