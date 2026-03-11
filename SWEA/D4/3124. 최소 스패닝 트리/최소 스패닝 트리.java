import java.io.*;
import java.util.*;

public class Solution {

	static int V, E;
	static List<Edge>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[V+1];
			for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				adj[u].add(new Edge(v, w));
				adj[v].add(new Edge(u, w));
			}
			
			long result = prim(1);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	static long prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
		visited = new boolean[V + 1];

		long totalWeight = 0;
		int count = 0;
		
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visited[now.to]) continue;
			visited[now.to] = true;
			totalWeight += now.weight;
			count++;
			
			for(Edge next : adj[now.to]) {
				if(visited[next.to]) continue;
				pq.offer(next);
			}
		}
		
		return totalWeight;
	}

	static class Edge {
		int to, weight;

		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
