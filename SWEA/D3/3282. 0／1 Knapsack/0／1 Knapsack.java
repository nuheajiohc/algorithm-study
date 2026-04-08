import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] volume = new int[N+1];
			int[] cost = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				volume[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[N+1][K+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=K; j++) {
					if(j>=volume[i]) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-volume[i]]+cost[i]);
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(dp[N][K]).append("\n");
		}
		
		System.out.println(sb);
	}
}
