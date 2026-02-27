import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static char[][] map;
	static int[][][] visited;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited = new int[N][M][2];
		
		int minDistance = bfs();
		System.out.println(minDistance);
	}
	
	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 0});
		visited[0][0][0] = 1;
		
		if(N==1 && M==1) return 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int wall = cur[2];
			for(int dir=0; dir<4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

				if(nx==N-1 && ny==M-1) {
					return visited[x][y][wall]+1;
				}
				
				if(map[nx][ny]=='0') {
					if(visited[nx][ny][wall]>0) continue;
					visited[nx][ny][wall] = visited[x][y][wall] + 1;
					q.offer(new int[] {nx, ny, wall});
				}else {
					if(wall==0) {
						if(visited[nx][ny][wall+1]>0) continue;
						visited[nx][ny][wall+1] = visited[x][y][wall] + 1;
						q.offer(new int[] {nx, ny, wall+1});
					}
				}

			}
		}
		
		return -1;
	}

}
