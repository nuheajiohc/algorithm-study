import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, X;
	static List<Edge>[] adj;
	static int[][] dist;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Edge(v, w));
		}
		
		dist = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		for(int i=1; i<=N; i++) dijkstra(i);
		
		int time = 0;
		for(int i=1; i<=N; i++) {
			if(dist[i][X]== INF || dist[X][i]==INF) continue;
			time = Integer.max(time, dist[i][X] + dist[X][i]);
		}
		
		System.out.println(time);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		dist[start][start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(start!=X && now.to==X) return;
			if(now.weight != dist[start][now.to]) continue;

			for(Edge next : adj[now.to]) {
				if(dist[start][next.to] <= dist[start][now.to] + next.weight) continue;
				dist[start][next.to] = dist[start][now.to] + next.weight;
				pq.offer(new Edge(next.to, dist[start][next.to]));
			}
		}
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
