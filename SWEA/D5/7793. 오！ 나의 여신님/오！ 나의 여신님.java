import java.io.*;
import java.util.*;

public class Solution {

	static int N, M;
	static char[][] board;
	static int[][] visited;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int sx = 0;
			int sy = 0;
			Queue<int[]> queue = new ArrayDeque<>();
			board = new char[N][M];
			visited = new int[N][M];
			
			for(int i=0; i<N; i++) Arrays.fill(visited[i], -1);
			
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				
				for(int j=0; j<M; j++) {
					board[i][j] = line.charAt(j);
					
					if(board[i][j]=='S') {
						sx = i;
						sy = j;
					}
					if(board[i][j] == '*') {
						queue.offer(new int[] {i, j});
						visited[i][j] = 0;
					}
				}
			}
			
			devilMove(queue);
			queue.offer(new int[] {sx, sy});
			visited[sx][sy] = 0;
			int answer = suMove(queue); 
			
			sb.append("#").append(tc).append(" ").append(answer==-1 ? "GAME OVER" : answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void devilMove(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(board[nx][ny]=='X' || board[nx][ny]=='D') continue;
				if(visited[nx][ny]==-1) {
					visited[nx][ny] = visited[x][y] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	static int suMove(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(board[nx][ny]=='X') continue;
				if(board[nx][ny]=='D') return visited[x][y] + 1;
				
				if(visited[nx][ny]==-1 || visited[nx][ny] > visited[x][y] +1) {
					visited[nx][ny] = visited[x][y] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		return -1;
	}
}
