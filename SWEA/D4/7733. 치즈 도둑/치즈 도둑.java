import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxCount = 1;
			for(int i=1; i<=100; i++) {
				int cnt = bfs(i);
				maxCount = Math.max(cnt, maxCount);
			}
			sb.append("#").append(tc).append(" ").append(maxCount).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int taste) {
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]<=taste) visited[i][j] = true;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				visited[i][j] = true;
				cnt ++;
				Queue<int[]> q = new ArrayDeque<>();
				q.offer(new int[] {i,j});
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					for(int dir=0; dir<4; dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
						if(visited[nx][ny]) continue;
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		return cnt;
	}
}
