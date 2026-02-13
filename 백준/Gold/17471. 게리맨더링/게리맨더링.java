import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<Integer>[] adj;
	static int[] person;
	static boolean[] used;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		person = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		used = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				adj[i].add(v);
				adj[v].add(i);
			}
		}
		
		combination(1);
		
		if(minDiff == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(minDiff);
		}
	}
	
	static void combination(int depth) {
		if(depth == N+1) {
			if(divideable()) {
				minDiff = Math.min(minDiff, findDiff());
			}
			return;
		}
		
		used[depth] = true;
		combination(depth+1);
		used[depth] = false;
		combination(depth+1);
	}
	
	static boolean divideable() {
		boolean[] vis = new boolean[N+1];
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(vis[i]) continue;
			cnt++;
			boolean flag = used[i];
			Queue<Integer> queue = new ArrayDeque<>();
			queue.offer(i);
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				for(int next : adj[cur]) {
					if(vis[next]) continue;
					if(flag != used[next]) continue;
					vis[next] = true;
					queue.offer(next);	
				}
			}
		}
		return cnt == 2;
	}
	
	static int findDiff() {
		int area1 = 0;
		int area2 = 0;
		for(int i=1; i<=N; i++) {
			if(used[i]) {
				area1 += person[i];
			}else {
				area2 += person[i];	
			}
		}
		return Math.abs(area1-area2);
	}

}
