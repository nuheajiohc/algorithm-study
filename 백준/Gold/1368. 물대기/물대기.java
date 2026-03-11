import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<Edge>[] adj;
	static int[] cost;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N];
		for(int i=0; i<N; i++) adj[i] = new ArrayList<>();
		cost = new int[N];
		
		int minCostIdx = 0;
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
			if(cost[minCostIdx] > cost[i]) minCostIdx = i;
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int w = Integer.parseInt(st.nextToken());
				adj[i].add(new Edge(j, w));
				adj[j].add(new Edge(i, w));
			}
		}
		
		int minCost = prim(minCostIdx);
		System.out.println(minCost);
		
	}
	
	static int prim(int start) {
		visited = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.offer(new Edge(start, cost[start]));

		int totalWeight = 0;
		int count = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visited[now.to]) continue;
			visited[now.to] = true;
			
			totalWeight += now.weight;
			count++;
			
			if(count == N) break;
			
			for(Edge next : adj[now.to]) {
				if(visited[next.to]) continue; 
				pq.offer(next);
				pq.offer(new Edge(next.to, cost[next.to]));
			}
		}
		
		return totalWeight;
	}
	
	static class Edge implements Comparable<Edge> {
		int to, weight;
		
		Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}
