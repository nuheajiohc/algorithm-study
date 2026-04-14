import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int[][] map;
	static int INF = Integer.MAX_VALUE;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}

			int ans = dijkstra();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
	}

	static int dijkstra() {
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], INF);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

		pq.offer(new int[] { 0, 0, 0 });
		dist[0][0] = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int y = cur[1];
			int d = cur[2];

			if (d != dist[x][y])
				continue;

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				int nd = map[nx][ny];

				if (dist[nx][ny] <= dist[x][y] + nd)
					continue;

				dist[nx][ny] = dist[x][y] + nd;
				pq.offer(new int[] { nx, ny, dist[nx][ny] });
			}
		}

		return dist[N - 1][N - 1];
	}
}