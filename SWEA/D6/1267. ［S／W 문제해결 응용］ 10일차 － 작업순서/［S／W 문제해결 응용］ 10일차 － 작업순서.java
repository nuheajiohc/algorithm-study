import java.io.*;
import java.util.*;

public class Solution {
	
	static int V, E;
	static List<Integer>[] adj;
	static int[] degree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[V+1];
			for(int i=1; i<=V; i++) adj[i] = new ArrayList<>();
			
			degree = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				degree[b]++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			for(int i=1; i<=V; i++) {
				if(degree[i]==0) q.offer(i); 
			}
			
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				sb.append(cur).append(" ");
				for(int next : adj[cur]) {
					if(--degree[next]>0) continue;
					q.offer(next);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
