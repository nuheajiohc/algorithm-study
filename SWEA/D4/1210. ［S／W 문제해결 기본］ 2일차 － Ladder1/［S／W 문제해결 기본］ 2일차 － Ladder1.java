import java.io.*;
import java.util.*;

public class Solution {
	
	private static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int _=1; _<=10; _++) {
			int T = Integer.parseInt(br.readLine());
			
			board = new int[100][100];
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int start = 0;
			for(int i=0; i<100; i++) {
				if(board[99][i]==2) {
					start = i;
					break;
				}
			}	
			dfs(99, start);
			
			for(int i=0; i<100; i++) {
				if(board[0][i]==2) {
					sb.append("#").append(T).append(" ").append(i).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		board[x][y] = 2;
		
		if(y-1>=0 && board[x][y-1]==1) {
			dfs(x, y-1);
			return;
		}
		
		if(y+1<100 && board[x][y+1]==1) {
			dfs(x, y+1);
			return;
		}
		
		if(x-1>=0 && board[x-1][y]==1) {
			dfs(x-1, y);
			return;
		}
	}
}