import java.io.*;
import java.util.*;

public class Solution {

	static int[] parent;
	static long[] xs = new long[1000];
	static long[] xy = new long[1000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {

			int N = Integer.parseInt(br.readLine());

			List<Edge> edges = new ArrayList<>();
			parent = new int[N+1];
			Arrays.fill(parent, -1);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				xs[x] = Long.parseLong(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int y=0; y<N; y++) {
				xy[y] = Long.parseLong(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long dist = (xs[i]-xs[j])*(xs[i]-xs[j]) + (xy[i]-xy[j])*(xy[i]-xy[j]);
					edges.add(new Edge(i, j, dist));
				}
			}
			
			long answer = (long)Math.round(kruskal(N, edges) * E);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static long kruskal(int V, List<Edge> edges) {
		Collections.sort(edges);

		long mstCount = 0;
		int edgeCount = 0;

		for (Edge edge : edges) {
			if (union(edge.v, edge.u)) {
				mstCount += edge.weight;
				edgeCount++;

				if (edgeCount == V - 1)
					break;
			}
		}

		return mstCount;
	}

	static int find(int u) {
		if (parent[u] < 0)
			return u;

		return parent[u] = find(parent[u]);
	}

	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);

		if (u == v)
			return false;

		if (parent[u] < parent[v]) {
			parent[u] += parent[v];
			parent[v] = u;
		} else {
			parent[v] += parent[u];
			parent[u] = v;
		}

		return true;
	}

	static class Edge implements Comparable<Edge> {
		int u, v;
		long weight;

		Edge(int u, int v, long weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

	}

}
