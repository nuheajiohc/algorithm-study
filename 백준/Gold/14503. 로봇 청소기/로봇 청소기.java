import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int startX, startY, startD;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] area;
	static int DIRTY = 0, WALL = 1, COMPLETED = 2;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		startD = Integer.parseInt(st.nextToken());
		
		area = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		operateRobot();
		
		System.out.println(count);
	}
	
	static void operateRobot() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {startX, startY, startD});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int d = cur[2];
			
			if(area[x][y] == DIRTY) {
				area[x][y] = COMPLETED;
				count++;
			}
			
			if(!hasDirtyArea(x, y)) {
				if(canGoBack(x, y, d)) {
					int nextD = (d+2) % 4;
					int nx = x + dx[nextD];
					int ny = y + dy[nextD];
					queue.offer(new int[] {nx, ny, d});
				}else {
					return;
				}
			}else {
				int nextD = (d+3) % 4;
				int nx = x + dx[nextD];
				int ny = y + dy[nextD];
				if(area[nx][ny]==DIRTY) {
					queue.offer(new int[] {nx, ny, nextD});
				}else {
					queue.offer(new int[] {x, y, nextD});
				}
			}
		}
	}
	
	static boolean hasDirtyArea(int x, int y) {
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(area[nx][ny]==DIRTY) return true; 
		}
		return false;
	}
	
	static boolean canGoBack(int x, int y, int d) {
		int backD = (d+2) % 4;
		int nx = x + dx[backD];
		int ny = y + dy[backD];
		
		return area[nx][ny]!=WALL;
	}

}
