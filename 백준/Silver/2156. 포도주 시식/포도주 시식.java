import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][2];
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][1] = arr[1];
		
		if(n>1) {
			dp[2][0] = arr[1];
			dp[2][1] = arr[1] + arr[2];
		}

		for(int i=3; i<=n; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = arr[i] + Math.max(dp[i-1][0], arr[i-1] + dp[i-2][0]);
		}
		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}

}

