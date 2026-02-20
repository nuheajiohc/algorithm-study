import java.io.*;
import java.util.*;

public class Solution {
	
	static char[][] board = new char[100][100];
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			String t = br.readLine();
			
			Queue<int[]> q = new ArrayDeque<>();
			for(int i=0; i<100; i++) {
				String line = br.readLine();
				for(int j=0; j<100; j++) {
					board[i][j] = line.charAt(j);
					if(board[i][j]=='2') {
						q.offer(new int[] {i, j});
						board[i][j] = '1';
					}
				}
			}
			
			int possible = bfs(q);
			sb.append("#").append(t).append(" ").append(possible).append("\n"); 
		}
		System.out.println(sb);

	}
	
	static int bfs(Queue<int[]> q) {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx<0|| nx>=100 || ny<0 || ny>=100) continue;
				if(board[nx][ny]=='1') continue;
				if(board[nx][ny]=='3') return 1;
				board[nx][ny] = '1';
				q.offer(new int[] {nx,ny});
			}
		}
		return 0;
	}
}