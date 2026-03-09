import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int N, M;
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
			adj = new ArrayList[N+1];
			for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
			
			while(M-->0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				adj[u].add(v);
				adj[v].add(u);
			}
			
			int cnt = 0;
			for(int i=1; i<=N; i++) {
				if(visited[i]) continue;
				dfs(i);
				cnt ++;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int cur) {
		visited[cur] = true;
		for(int next : adj[cur]) {
			if(visited[next]) continue;
			dfs(next);
		}
	}

}
