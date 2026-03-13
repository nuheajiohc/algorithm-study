import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static boolean[][] minPath;
	static List<int[]>[] adj;
	static int INF = Integer.MAX_VALUE;
	static List<Integer>[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adj = new ArrayList[N];
			for (int i = 0; i < N; i++)
				adj[i] = new ArrayList<>();

			parent = new ArrayList[N];
			for (int i = 0; i < N; i++)
				parent[i] = new ArrayList<>();

			minPath = new boolean[N][N];

			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				adj[u].add(new int[] { v, w });
			}

			boolean hasMinPath = findMinPath(start, end);

			if (!hasMinPath) {
				sb.append(-1).append("\n");
				continue;
			}

			Queue<Integer> q = new ArrayDeque<>();
			q.offer(end);

			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int p : parent[cur]) {
					if (minPath[p][cur])
						continue;
					minPath[p][cur] = true;
					if (p == start)
						continue;
					q.offer(p);
				}
			}

			int answer = dijkstra(start, end);

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static int dijkstra(int start, int end) {
		int[] dist = new int[N];
		Arrays.fill(dist, INF);

		dist[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0];
			int w = cur[1];

			if (w != dist[v])
				continue;

			if (v == end)
				return dist[end];

			for (int[] next : adj[v]) {
				int nv = next[0];
				int nw = next[1];

				if (minPath[v][nv])
					continue;
				if (dist[nv] < dist[v] + nw)
					continue;
				dist[nv] = dist[v] + nw;
				pq.offer(new int[] { nv, dist[nv] });
			}
		}

		return -1;
	}

	static boolean findMinPath(int start, int end) {
		int[] dist = new int[N];
		Arrays.fill(dist, INF);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] { start, 0 });
		dist[start] = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0];
			int w = cur[1];

			if (w != dist[v])
				continue;

			for (int[] next : adj[v]) {
				int nv = next[0];
				int nw = next[1];

				if (dist[nv] == dist[v] + nw) {
					parent[nv].add(v);
				} else if (dist[nv] > dist[v] + nw) {
					parent[nv].clear();
					parent[nv].add(v);
					dist[nv] = dist[v] + nw;
					pq.offer(new int[] { nv, dist[nv] });
				}

			}
		}

		return dist[end] != INF;
	}
}
