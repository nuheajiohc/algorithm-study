import java.io.*;
import java.util.*;

public class Main {
	
	static int N, R, Q;
	static List<Integer>[] adj;
	static boolean[] visited;
	static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		size = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		calculateSubTreeCount(R);
		
		StringBuilder sb = new StringBuilder();
		while(Q-->0) {
			int U = Integer.parseInt(br.readLine());
			sb.append(size[U]).append("\n");
		}
		
		System.out.println(sb);
	}

	static int calculateSubTreeCount(int node) {
		if(size[node]>0) return size[node];
		
		visited[node] = true;
		int cnt = 1;
		for(int next : adj[node]) {
			if(visited[next]) continue;
			cnt += calculateSubTreeCount(next);
		}
		
		return size[node] = cnt;
	}
}
