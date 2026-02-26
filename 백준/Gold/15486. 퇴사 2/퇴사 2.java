import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] T, P, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		T = new int[N+1];
		P = new int[N+1];
		dp = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			T[i] = t;
			P[i] = p;
		}
		
		for(int i=1; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], dp[i]);
			if(i+T[i]-1 <= N) {
				dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i]+P[i]);	
			}

		}
		
		int max = 0;
		for(int i=1; i<=N+1; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
