import java.io.*;
import java.util.*;

public class Solution {

	static int N, M;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];

			Queue<int[]> devilQ = new ArrayDeque<>();
			Queue<int[]> syQ = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);

					if (map[i][j] == '*') {
						devilQ.offer(new int[] { i, j });
					} else if (map[i][j] == 'S') {
						syQ.offer(new int[] { i, j, 0 });
					}
				}
			}

			int result = bfs(devilQ, syQ);

			sb.append("#").append(tc).append(" ");
			if (result == -1) {
				sb.append("GAME OVER\n");
			} else {
				sb.append(result).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static int bfs(Queue<int[]> devilQ, Queue<int[]> syQ) {

		while (!syQ.isEmpty()) {
			int devilSize = devilQ.size();
			while (devilSize-- > 0) {
				int[] cur = devilQ.poll();
				int x = cur[0];
				int y = cur[1];

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (isOutOfRange(nx, ny))
						continue;
					if (map[nx][ny] == 'D' || map[nx][ny] == 'X' || map[nx][ny] == '*')
						continue;
					map[nx][ny] = '*';
					devilQ.offer(new int[] { nx, ny });
				}
			}

			int sySize = syQ.size();
			while (sySize-- > 0) {
				int[] cur = syQ.poll();
				int x = cur[0];
				int y = cur[1];
				int t = cur[2];

				for (int dir = 0; dir < 4; dir++) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (isOutOfRange(nx, ny))
						continue;
					if (map[nx][ny] == 'X' || map[nx][ny] == '*' || map[nx][ny] == 'S')
						continue;
					
					if (map[nx][ny] == 'D') {
						return t + 1;
					}
					
					map[nx][ny] = 'S';
					syQ.offer(new int[] { nx, ny, t + 1 });
				}
			}
		}
		return -1;
	}

	static boolean isOutOfRange(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= M;
	}

}
