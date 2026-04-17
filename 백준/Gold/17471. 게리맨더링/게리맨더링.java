import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static List<Integer>[] adj;
	static boolean[] used;
	static int[] person;
	static int[] parent;
	static int minDiff = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
	
		used= new boolean[N+1];
		person = new int[N+1];
		parent = new int[N+1];
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
			}
		}
		
		subset(1);
		System.out.println(minDiff==Integer.MAX_VALUE ? -1 : minDiff);
	}
	
	static int calParent(){
		Arrays.fill(parent, -1);
		
		for(int i=1; i<=N; i++) {
			for(int next : adj[i]) {
				if(used[i] == used[next]) {
					union(i, next);
				}
			}
		}
		
		int rootCount = 0;
		for(int i=1; i<=N; i++) {
			if(parent[i]<0) {
				rootCount++;
			}
		}
		return rootCount;
	}
	
	static void subset(int depth) {
		if(depth==N+1) {
			int parentCount = calParent();
			if(parentCount==2) {
				int aSum = 0;
				int bSum = 0;
				
				for(int i=1; i<=N; i++) {
					if(used[i]) aSum +=person[i];
					else bSum += person[i];
				}
				
				minDiff = Math.min(minDiff, Math.abs(aSum - bSum));
			}
			return;
		}
		
		used[depth] = true;
		subset(depth+1);
		
		used[depth] = false;
		subset(depth+1);
	}

	
	static int find(int u) {
		if(parent[u]<0) return u;
		
		return parent[u] = find(parent[u]);
	}
	
	static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		
		if(u==v) {
			return false;
		}
		
		if(parent[u] > parent[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		parent[u] += parent[v];
		parent[v] = u;
		
		return true;
	}

}
