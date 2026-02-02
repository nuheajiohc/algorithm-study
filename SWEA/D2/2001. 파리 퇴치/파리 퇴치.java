import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int tmp = 0;
					for(int k=i; k<i+M; k++) {
						for(int l=j; l<j+M; l++) {
							tmp += board[k][l];
						}
					}
					max = Math.max(max, tmp);
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}

}
