import java.io.*;
import java.util.*;

public class Solution {

	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Edge> edges = new ArrayList<>();
			while(E-->0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges.add(new Edge(u, v, w));
			}
			
			long minWeight = kruskal(V, edges);
			sb.append("#").append(tc).append(" ").append(minWeight).append("\n");
		}
		System.out.println(sb);
	}
	
	static long kruskal(int V, List<Edge> edges) {
		Collections.sort(edges);
		
		parent = new int[V+1];
		Arrays.fill(parent, -1);
		
		long mstWeight = 0;
		int edgeCount = 0;
		for(Edge edge : edges) {
			if(union(edge.u, edge.v)) {
				mstWeight += edge.weight;
				edgeCount++;
				
				if(edgeCount == V-1) break;
			}
		}
		return mstWeight;
	}

	static int find(int u) {
		if (parent[u] < 0) return u;

		return parent[u] = find(parent[u]);
	}

	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);

		if (u == v)
			return false;

		if (parent[u] > parent[v]) {
			parent[v] += parent[u];
			parent[u] = v;
		} else {
			parent[u] += parent[v];
			parent[v] = u;
		}

		return true;
	}

	static class Edge implements Comparable<Edge> {

		int u, v, weight;

		Edge(int u, int v, int weight){
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

        public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

}
