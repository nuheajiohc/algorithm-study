import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] board;
	static List<int[]> virus = new ArrayList<>();
	static List<int[]> blank = new ArrayList<>();
	static int[][] copiedBoard;
	static boolean[] used;
	static int maxSafeZone = 0;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		copiedBoard = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					virus.add(new int[] { i, j });
				}

				if (board[i][j] == 0) {
					blank.add(new int[] { i, j });
				}
			}
		}

		used = new boolean[blank.size()];
		combination(0, 0);
		System.out.println(maxSafeZone);
	}

	static void combination(int depth, int k) {
		if (depth == 3) {
			int safeZone = bfs();
			maxSafeZone = Math.max(maxSafeZone, safeZone);
			return;
		}

		for (int i = k; i < blank.size(); i++) {
			used[i] = true;
			combination(depth + 1, i + 1);
			used[i] = false;
		}
	}

	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copiedBoard[i][j] = board[i][j];
			}
		}

		for (int[] v : virus) {
			queue.offer(v);
		}

		for (int i = 0; i < used.length; i++) {
			if (used[i]) {
				int[] p = blank.get(i);
				copiedBoard[p[0]][p[1]] = 1;
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (copiedBoard[nx][ny] != 0)
					continue;
				copiedBoard[nx][ny] = 2;
				queue.offer(new int[] { nx, ny });
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copiedBoard[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}
