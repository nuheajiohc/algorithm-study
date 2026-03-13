import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Edge>[] adj;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
	}
	
	static int dijkstra(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.v == end) break;
			
			if(cur.dist != dist[cur.v]) continue;
			
			for(Edge next : adj[cur.v]) {
				if(dist[next.to] <= dist[cur.v] + next.weight) continue;
				dist[next.to] = dist[cur.v] + next.weight;
				
				pq.offer(new Node(next.to, dist[next.to]));
			}
		}
		
		return dist[end];
	}

	static class Edge {
		int to;
		int weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static class Node implements Comparable<Node> {
		int v;
		int dist;

		Node(int v, int dist) {
			this.v = v;
			this.dist = dist;
		}

		public int compareTo(Node o) {
			return Integer.compare(dist, o.dist);
		}
	}

}
