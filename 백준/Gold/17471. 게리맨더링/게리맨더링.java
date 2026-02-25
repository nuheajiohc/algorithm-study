import java.io.*;
import java.util.*;

public class Main {
	
	static int N, minDiff;
	static int[] population;
	static List<Integer>[] adj;
	static boolean[] used;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		population = new int[N+1];
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		
		used = new boolean[N+1];
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for(int u=1; u<=N; u++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while(st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
		}
		
		minDiff = Integer.MAX_VALUE;
		combination(0);
		
		if(minDiff == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(minDiff);
		}
	}
	
	static void combination(int depth) {
		if(depth==N) {
			if(canDivide()) {
				int diffValue = calDiff();
				minDiff = Math.min(minDiff, diffValue);
			}
			return;
		}
		
		used[depth] = true;
		combination(depth+1);
		used[depth] = false;
		combination(depth+1);
	}

	static boolean canDivide() {
		boolean[] vis = new boolean[N+1];
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(vis[i]) continue;
			vis[i] = true;
			cnt++;
			
			if(cnt>2) return false;
			
			boolean target = used[i];
			
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(i);
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int next : adj[cur]) {
					if(vis[next]) continue;
					if(used[next]!=target)continue;
					vis[next] = true;
					q.offer(next);
				}
			}
		}
		return cnt==2;
	}
	
	static int calDiff() {
		int part1 = 0;
		int part2 = 0;
		for(int i=1; i<=N; i++) {
			if(used[i]) part1+=population[i];
			else part2+=population[i];
		}
		
		return Math.abs(part1-part2);
	}
}
