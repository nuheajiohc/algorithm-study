import java.io.*;
import java.util.*;

public class Main {
	public static void  main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] m = new int[N+1];
		int[] c = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int sumC = 0;
		for(int i=1; i<=N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			sumC += c[i];
		}
		int[][] dp = new int[N+1][sumC+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=sumC; j++) {
				if(j>=c[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]] + m[i]); 
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		int answer = 0;
		for(int j=0; j<=sumC; j++) {
			if(dp[N][j]>=M) {
				answer = j;
				break;
			}
		}
		System.out.println(answer);
	}
}