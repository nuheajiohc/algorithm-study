import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N;
	static int[][] board;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1) {
					 q.offer(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(board[nx][ny]!=0) continue;
				board[nx][ny] = board[cur[0]][cur[1]] + 1;
				q.offer(new int[] {nx, ny});
			}
		}

		System.out.println(check());
	}
	
	static int check() {
		int day = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j]==0) return -1;
				day = Math.max(day, board[i][j]);
			}
		}
		return day-1;
	}
}
