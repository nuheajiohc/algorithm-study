import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static List<Integer>[] adj;
	static int[] person;
	static boolean[] used;
	static int minDiff;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		minDiff = Integer.MAX_VALUE;
		used= new boolean[N+1];
		person = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				int conn = Integer.parseInt(st.nextToken());
				adj[i].add(conn);
				adj[conn].add(i);
			}
		}
		
		subset(1);
		
		System.out.println(minDiff==Integer.MAX_VALUE ? -1 : minDiff);
	}
	
	static int bfs(boolean area) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			if(used[i]==area) {
				q.offer(i);
				visited[i] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adj[cur]) {
				if(visited[next]) continue;
				if(used[next]!=area) continue;
				visited[next] = true;
				q.offer(next);
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(visited[i]) cnt++; 
		}
		return cnt;
	}
	
	static int calDiff() {
		int diff = 0;
		for(int i=1; i<=N; i++) {
			if(used[i]) {
				diff+=person[i];
			}else {
				diff-=person[i];
			}
		}
		return Math.abs(diff);
	}
	
	static void subset(int depth) {
		if(depth==N+1) {
			int A = bfs(true);
			int B = bfs(false);
			if(A+B == N) {
				minDiff = Math.min(minDiff, calDiff());
			}
			return;
		}
		
		used[depth] = true;
		subset(depth+1);
		
		used[depth] = false;
		subset(depth+1);
	}

}
