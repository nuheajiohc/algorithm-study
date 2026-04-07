import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] tower;
	static List<Integer>[] adj, reversed;
	static int[] dp;
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		tower = new int[N][3];
		dp = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				tower[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		adj = new ArrayList[N];
		for(int i=0;i<N; i++) adj[i] = new ArrayList<>();
		
		reversed = new ArrayList[N];
		for(int i=0;i<N; i++) reversed[i] = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			dp[i] = tower[i][1];
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(tower[i][0] > tower[j][0] && tower[i][2] > tower[j][2]) {
					adj[i].add(j);
					reversed[j].add(i);
				}
			}
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j : adj[i]) {
					dp[j] = Math.max(dp[j], dp[i] + tower[j][1]);
				}
			}	
		}
		
		int maxValue = 0;
		int maxIdx = -1;
		for(int i=0; i<N; i++) {
			if(maxValue < dp[i]) {
				maxValue = dp[i];
				maxIdx = i;
			}
		}
		
		dfs(maxIdx);
		
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		sb.append(v+1).append("\n");
		cnt++;
		for(int next : reversed[v]) {
			if(dp[next] == dp[v]-tower[v][1]) {
				dfs(next);
			}
		}
	}
}
