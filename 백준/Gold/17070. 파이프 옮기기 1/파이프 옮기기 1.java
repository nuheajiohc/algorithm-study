import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] house;
	static int[][][] dp;
	static int[] dx = {0, 1, 1}; // 우, 우하, 하
	static int[] dy = {1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][N+1];
		dp = new int[N+1][N+1][3];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;
		for(int i=1; i<=N; i++) {
			for(int j=2; j<=N; j++) {
				if(house[i][j]==1) continue;
				dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][1];
				
				if(house[i-1][j]!=1 && house[i][j-1]!=1) {
					dp[i][j][1] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];	
				}
				
				dp[i][j][2] += dp[i-1][j][2] + dp[i-1][j][1];
				
			}
		}
		
		System.out.println(dp[N][N][0]+ dp[N][N][1] + dp[N][N][2]);
	}
}
