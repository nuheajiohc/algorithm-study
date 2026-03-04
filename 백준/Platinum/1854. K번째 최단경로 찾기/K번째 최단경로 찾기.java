import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, k;
	static List<int[]>[] adj;
	static PriorityQueue<Integer>[] pqDist; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		pqDist = new PriorityQueue[n+1];
		for(int i=1; i<=n; i++) {
			pqDist[i] = new PriorityQueue<>((a,b)->b-a);
		}
		
		adj = new ArrayList[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adj[u].add(new int[] {v, w});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		pq.offer(new int[] {1, 0});
		pqDist[1].offer(0);
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0]; int w = cur[1];
			
			if(pqDist[v].size()==k && w > pqDist[v].peek()) continue;
			
			for(int[] next : adj[v]) {
				int nv = next[0]; int nw = next[1];
				int newCost = w + nw;
				if(pqDist[nv].size() < k) {
					pqDist[nv].offer(newCost);
					pq.offer(new int[] {nv, newCost});
				}
				else if(pqDist[nv].peek() > newCost) {
					pqDist[nv].poll();
					pqDist[nv].offer(newCost);
					pq.offer(new int[] {nv, newCost});
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(pqDist[i].size()<k) {
				sb.append(-1).append("\n");
			}else {
				sb.append(pqDist[i].poll()).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}
