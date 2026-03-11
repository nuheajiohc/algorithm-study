import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<int[]>[] adj;
	static int[] dist;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[u].add(new int[] { v, w });
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start, end);
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");
		int cnt = 1;
		int city = end;
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.offer(city);
		while(city!=start) {
			city = parent[city];
			cnt++;
			stack.offerLast(city);
		}
		sb.append(cnt).append("\n");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast()).append(" ");
		}
		
		System.out.println(sb);
		
	}

	static void dijkstra(int start, int end) {
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] { start, 0});
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int u = cur[0];
			int w = cur[1];
			if(u == end) return;
			if(dist[u] != w) continue;
			
			for(int[] next : adj[u]) {
				int nu = next[0];
				int nw = next[1];
				
				if(dist[nu] <= dist[u] + nw) continue;
				dist[nu] = dist[u] + nw;
				parent[nu] = u;
				pq.offer(new int[] { nu, dist[nu]});
			}
		}
	}

}
