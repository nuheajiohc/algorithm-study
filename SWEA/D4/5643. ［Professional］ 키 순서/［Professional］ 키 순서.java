import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M;
	static int[][] dist;
	static int[] record;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			dist = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				Arrays.fill(dist[i], 501);
			}
			
			while(M-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				dist[a][b] = 1;
			}

			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					for(int j=1; j<=N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}
			
			int result = 0;
			for(int i=1; i<=N; i++) {
				int cnt = 0;
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(dist[i][j]<501 || dist[j][i]<501) cnt++;
				}
				if(cnt==N-1) result++;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
