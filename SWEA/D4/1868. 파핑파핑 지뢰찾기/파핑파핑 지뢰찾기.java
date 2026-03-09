import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static char[][] board;
	static int[][] trace;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());

			board = new char[N][];

			for (int i = 0; i < N; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			trace = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = countBomb(i, j);
					trace[i][j] = cnt;
				}
			}

			int click = 0;
			Queue<int[]> queue = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!(trace[i][j] == 0 && board[i][j] != '*')) continue;
					if (visited[i][j]) continue;
					
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					click++;
					while (!queue.isEmpty()) {
						int[] cur = queue.poll();
						int x = cur[0];
						int y = cur[1];
						if (countBomb(x, y) == 0) {
							for (int dir = 0; dir < 8; dir++) {
								int nx = x + dx[dir];
								int ny = y + dy[dir];
								if (nx < 0 || nx >= N || ny < 0 || ny >= N)
									continue;
								if(visited[nx][ny]) continue;
								visited[nx][ny] = true;

								if (trace[nx][ny] == 0 && board[nx][ny] != '*') {
									queue.offer(new int[] { nx, ny });
								}
							}
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && trace[i][j] > 0 && board[i][j]!='*')
						click++;
				}
			}

			sb.append("#").append(tc).append(" ").append(click).append("\n");
		}
		System.out.println(sb);
	}

	static int countBomb(int x, int y) {
		int cnt = 0;
		for (int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (board[nx][ny] == '*')
				cnt++;
		}
		return cnt;
	}
}
