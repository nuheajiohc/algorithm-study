import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] adj;
	static int[] good;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		good = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int v = Integer.parseInt(st.nextToken());
			if(v==-1) continue;
			adj[v].add(i);
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			good[i] += w;
		}
		
		calculateGood(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(good[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	static void calculateGood(int node) {
		for(int next : adj[node]) {
			good[next] += good[node];
			calculateGood(next);
		}
	}
}
