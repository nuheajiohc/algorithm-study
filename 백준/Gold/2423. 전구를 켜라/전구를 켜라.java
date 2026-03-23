import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Edge>[][] adj;
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1][M+1];
		adj = new ArrayList[N+1][M+1];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				adj[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				if(line.charAt(j)=='\\') {
					adj[i][j].add(new Edge(i+1, j+1, 0));
					adj[i+1][j+1].add(new Edge(i, j, 0));
					adj[i][j+1].add(new Edge(i+1, j, 1));
					adj[i+1][j].add(new Edge(i, j+1, 1));
				}else {
					adj[i][j].add(new Edge(i+1, j+1, 1));
					adj[i+1][j+1].add(new Edge(i, j, 1));
					adj[i][j+1].add(new Edge(i+1, j, 0));
					adj[i+1][j].add(new Edge(i, j+1, 0));
				}
			}
		}
		
		int answer = dijkstra();
		
		if(answer==-1) {
			System.out.println("NO SOLUTION");
		}else {
			System.out.println(answer);
		}
	}
	
	static int dijkstra() {
		for(int i=0; i<N+1; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		dist[0][0] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0, 0));
		dist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.weight != dist[now.x][now.y]) continue;
			if(now.x==N && now.y==M) return dist[N][M];
			
			for(Edge next : adj[now.x][now.y]) {
				int nextWeight = dist[now.x][now.y] + next.weight;
				
				if(dist[next.x][next.y] <= nextWeight) continue;
				dist[next.x][next.y] = nextWeight;
				pq.offer(new Edge(next.x, next.y, nextWeight));
			}
		}
		
		return -1;
	}
	
	static class Edge implements Comparable<Edge> {
		int x, y, weight;
		
		Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}