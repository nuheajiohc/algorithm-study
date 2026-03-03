import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	static int[][] board, gVisited, iVisited;
	static Queue<int[]> gas;
	static Queue<int[]> indi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			gVisited = new int[N][M];

			iVisited = new int[N][M];
			
			board = new int[N][M];
			gas = new ArrayDeque<>();
			indi = new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
					if(board[i][j]==2) {
						gas.offer(new int[] {i, j});
						gVisited[i][j] = 1;
					}
					if(board[i][j]==3) {
						indi.offer(new int[] {i, j});
						iVisited[i][j] = 1;
					}
				}
			}
			
			gasBfs();
			String state = indiBfs();
			sb.append("#").append(tc).append(" ").append(state).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static String indiBfs() {
		boolean zombie = false;
		
		while(!indi.isEmpty()) {
			int[] cur = indi.poll();
			int x = cur[0]; int y = cur[1];
			
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx<0 || nx>=N || ny<0 || ny>=M) {
					return iVisited[x][y]+"";
				}
				if(board[nx][ny]==1)continue;
				if(iVisited[nx][ny]>0) continue;
				iVisited[nx][ny] = iVisited[x][y] + 1;
				if(gVisited[nx][ny]>0 && gVisited[nx][ny]<=iVisited[nx][ny]) {
					zombie = true;
					continue;
				}
				indi.offer(new int[] {nx ,ny});
			}
		}
		
		if(zombie) return "ZOMBIE";
		return "CANNOT ESCAPE";
	}
	
	static void gasBfs() {
		while(!gas.isEmpty()) {
			int[] cur = gas.poll();
			int x = cur[0]; int y = cur[1];
			
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(board[nx][ny]==1)continue;
				if(gVisited[nx][ny]>0) continue;
				gVisited[nx][ny] = gVisited[x][y] + 1;
				gas.offer(new int[] {nx, ny});
			}
		}
	}
}
