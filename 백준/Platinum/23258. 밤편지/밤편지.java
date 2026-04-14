import java.io.*;
import java.util.*;

public class Main {
	
	static int N, Q;
	static int[][][] dist;
	static int INF = 100000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1][N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(i==j) dist[i][j][0] = 0;
				else if(value==0) dist[i][j][0] = INF;
				else dist[i][j][0] = value;
			}
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j][k] = Math.min(dist[i][j][k-1], dist[i][k][k-1]+dist[k][j][k-1]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(Q-->0) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(dist[s][e][C-1]==INF ? -1 : dist[s][e][C-1]).append("\n");
		}
		System.out.println(sb);
	}
}
