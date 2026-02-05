import java.io.*;
import java.util.*;

public class Solution {
	
	private static int N, M, C;
	private static int[][] board;
	private static int maxProfit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxProfit = 0;
			selectWorker(0, 0, 0, 0);
			sb.append("#").append(t).append(" ").append(maxProfit).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void selectWorker(int cnt, int r, int c, int currentTotal) {
		if(cnt==2) {
			maxProfit = Math.max(maxProfit, currentTotal);
			return;
		}
		
		for(int i=r; i<N; i++) {
			int startCol = (i==r) ? c : 0;
			
			for(int j=startCol; j<=N-M; j++) {
				int profit = getMaxMoney(i, j, 0, 0, 0);
				
				selectWorker(cnt+1, i, j+M, currentTotal + profit);
			}
		}
	}
	
	public static int getMaxMoney(int r, int c, int idx, int sum, int profit) {
		if(sum>C) return 0;
		if(idx==M) return profit;
		
		int honey = board[r][c+idx];
		int pick = 0;
		if(sum+honey<=C) {
			pick = getMaxMoney(r, c, idx+1, sum+honey, profit + honey* honey);
		}
		int skip = getMaxMoney(r,c,idx+1,sum,profit);
		return Math.max(pick, skip);
	}
	
}
