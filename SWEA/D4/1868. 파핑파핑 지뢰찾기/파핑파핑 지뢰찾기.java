import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int BOMB = -1, BLANK = 0, RISK = 1;
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());

			visited = new boolean[N][N];
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					char c = line.charAt(j);
					if (c == '*')
						board[i][j] = BOMB;
				}
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j]==BOMB) continue;
					if(hasBomb(i ,j)) board[i][j] = RISK;
				}
			}
			
			Queue<int[]> q = new ArrayDeque<>();

			int click = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != BLANK || visited[i][j])
						continue;
					visited[i][j] = true;
					click++;

					q.offer(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];

						for (int dir = 0; dir < 8; dir++) {
							int nx = x + dx[dir];
							int ny = y + dy[dir];
							if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
							if(visited[nx][ny]) continue;
							if(board[nx][ny]==BOMB) continue;
							visited[nx][ny] = true;
							if(board[nx][ny]==0) q.offer(new int[] {nx, ny});
						}
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && (board[i][j] == RISK)) click++;
				}
			}

			sb.append("#").append(tc).append(" ").append(click).append("\n");
		}
		System.out.println(sb);
	}

	static boolean hasBomb(int x, int y) {
		for (int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (board[nx][ny] == BOMB)
				return true;
		}
		return false;
	}
}
