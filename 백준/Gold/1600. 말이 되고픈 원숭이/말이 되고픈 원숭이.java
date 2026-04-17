import java.io.*;
import java.util.*;

public class Main {

	static int K, W, H;

	static int[] mdx = { 0, 0, 1, -1 };
	static int[] mdy = { 1, -1, 0, 0 };
	static int[] hdx = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int[] hdy = { 2, -2, 1, -1, 2, -2, 1, -1 };
	static int[][] board;
	static int[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new int[K + 1][H][W];

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = 1;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int k = cur[2];
			
			if(x==H-1 && y==W-1) {
				return visited[k][x][y] - 1;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + mdx[dir];
				int ny = y + mdy[dir];

				if (isOutOfRange(nx, ny))
					continue;
				if (board[nx][ny] == 1)
					continue;
				if (visited[k][nx][ny] > 0)
					continue;
				visited[k][nx][ny] = visited[k][x][y] + 1;
				q.offer(new int[] { nx, ny, k });
			}

			if (k < K) {
				for (int dir = 0; dir < 8; dir++) {
					int nx = x + hdx[dir];
					int ny = y + hdy[dir];

					if (isOutOfRange(nx, ny))
						continue;
					if (board[nx][ny] == 1)
						continue;
					if (visited[k + 1][nx][ny] > 0)
						continue;
					visited[k + 1][nx][ny] = visited[k][x][y] + 1;
					q.offer(new int[] { nx, ny, k + 1 });
				}
			}
		}
		return -1;
	}

	static boolean isOutOfRange(int x, int y) {
		return x < 0 || x >= H || y < 0 || y >= W;
	}

}
