import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][3];
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][1] = arr[1];
		
		for(int i=2; i<=n; i++) {
			dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
			dp[i][1] = arr[i] + dp[i-1][0];
			dp[i][2] = arr[i] + dp[i-1][1];
		}
		
		int max = Math.max(dp[n][0], dp[n][1]);
		max = Math.max(max, dp[n][2]);
		System.out.println(max);
	}
}
