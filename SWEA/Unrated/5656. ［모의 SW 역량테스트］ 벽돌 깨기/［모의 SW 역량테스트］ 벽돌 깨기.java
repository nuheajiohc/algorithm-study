import java.io.*;
import java.util.*;

public class Solution {

	static int N, W, H;
	static int[][] initMap = new int[15][12];
	static int minRemainBrick;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			minRemainBrick = 12 * 15;

			int totalBrick = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					initMap[i][j] = Integer.parseInt(st.nextToken());
					if (initMap[i][j] > 0)
						totalBrick++;
				}
			}

			permutation(0, totalBrick, initMap);

			sb.append("#").append(tc).append(" ").append(minRemainBrick).append("\n");
		}
		System.out.println(sb);
	}

	static void permutation(int depth, int remainBrick, int[][] nowMap) {
		if (depth == N) {
			minRemainBrick = Math.min(minRemainBrick, remainBrick);
			return;
		}

		for (int i = 0; i < W; i++) {
			int[][] nextMap = copyMap(nowMap);
			int brokenBrick = breakBrick(i, nextMap);
			gravityBrick(nextMap);
			permutation(depth + 1, remainBrick - brokenBrick, nextMap);
		}
	}
	
	static void gravityBrick(int[][] map) {
		for(int w=0; w<W; w++) {
			int idx = H-1;
			for(int h=H-1; h>=0; h--) {
				int tmp = map[h][w];
				if(tmp==0) continue;
				map[h][w] = 0;
				map[idx--][w] = tmp;
			}
			
		}
		
	}

	static int breakBrick(int w, int[][] map) {
		int targetH = -1;
		for (int i = 0; i < H; i++) {
			if (map[i][w] != 0) {
				targetH = i;
				break;
			}
		}
		
		if (targetH == -1) {
			return 0;
		}

		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { targetH, w, map[targetH][w] });
		map[targetH][w] = 0;
		cnt++;
	
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int len = now[2];
	
			for(int i=1; i<len; i++) {
				for(int dir=0; dir<4; dir++) {
					int nx = x + dx[dir]*i;
					int ny = y + dy[dir]*i;
					if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
					if(map[nx][ny]==0) continue;
					queue.offer(new int[] {nx, ny, map[nx][ny]});
					map[nx][ny] = 0;
					cnt++;
				}	
			}
		}
		return cnt;
	}

	static int[][] copyMap(int[][] nowMap) {
		int[][] nextMap = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				nextMap[i][j] = nowMap[i][j];
			}
		}

		return nextMap;
	}
}
