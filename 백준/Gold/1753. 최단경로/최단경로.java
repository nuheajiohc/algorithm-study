import java.io.*;
import java.util.*;

public class Main {
	
	static int V, E, start;
	static List<int[]>[] adj;
	static int[] distance;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		adj = new ArrayList[V+1];
		for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();
		
		while(E-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new int[] {v, w});
		}
		
		distance[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0];
			int w = cur[1];
			
			if(distance[v] != w) continue;
			
			for(int[] next : adj[v]) {
				int nv = next[0];
				int nw = next[1];
				
				if(distance[nv] <= distance[v] + nw) continue;
				distance[nv] = distance[v] + nw;
				pq.offer(new int[] {nv, distance[nv]});
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int v=1; v<=V; v++) {
			if(distance[v]==Integer.MAX_VALUE) {
				sb.append("INF");
			}else {
				sb.append(distance[v]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
