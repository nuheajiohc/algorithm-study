import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, K;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				int tmp = 0;
				for(int j=0; j<N; j++) {
					if(board[i][j]==1) tmp++;
					else {
						if(tmp==K) cnt++;
						tmp=0;
					}
				}
				if(tmp==K) cnt++;
			}
			
			for(int j=0; j<N; j++) {
				int tmp = 0;
				for(int i=0; i<N; i++) {
					if(board[i][j]==1) tmp++;
					else {
						if(tmp==K) cnt++;
						tmp = 0;
					}
				}
				if(tmp==K) cnt++;
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}
