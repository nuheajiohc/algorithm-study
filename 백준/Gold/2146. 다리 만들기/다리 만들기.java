import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] country;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	static int minLen = 10000;
	static int WATER = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		country = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideIslands();
	
		connectBridge();
		
		System.out.println(minLen);
	}
	
	static void connectBridge() {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] dist = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], -1);
			for(int j=0; j<N; j++) {
				if(country[i][j]==WATER) continue;
				if(!isInnerLand(i, j)) {
					queue.offer(new int[] {i,j});					
				}
				dist[i][j] = 0;
			}
		}
		
		while(!queue.isEmpty()) {
			int[] curPos = queue.poll();
			int x = curPos[0];
			int y = curPos[1];
			for(int dir=0; dir<4; dir++) {
				int nx = curPos[0] + dx[dir];
				int ny = curPos[1] + dy[dir];
				if(isOutRange(nx,ny)) continue;
				
				if(dist[nx][ny]==-1) {
					dist[nx][ny] = dist[x][y] + 1;
					country[nx][ny] = country[x][y];
					queue.offer(new int[] {nx,ny});
				}else if(country[nx][ny]!= country[x][y]) {
					minLen = Math.min(minLen, dist[x][y]+dist[nx][ny]);
				}
			}
		}
	}
	
	static void divideIslands() {
		boolean[][] vis = new boolean[N][N];
		
		int unique = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(vis[i][j] || country[i][j]==WATER) continue;
				unique--;
				
				vis[i][j] = true;
				country[i][j] = unique;
				Queue<int[]> queue = new ArrayDeque<>();
				queue.offer(new int[] {i,j});
				
				while(!queue.isEmpty()) {
					int[] curPos = queue.poll();
					
					for(int dir=0; dir<4; dir++) {
						int nx = curPos[0] + dx[dir];
						int ny = curPos[1] + dy[dir];
						
						if(isOutRange(nx,ny)) continue;
						if(vis[nx][ny]) continue;
						if(country[nx][ny] == WATER) continue;
						vis[nx][ny] = true;
						country[nx][ny] = unique;
						queue.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	static boolean isInnerLand(int x, int y) {
		for(int dir=0; dir<4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(isOutRange(nx,ny)) continue;
			if(country[nx][ny]==WATER) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isOutRange(int x, int y) {
		return x<0 || x>=N || y<0 || y>=N;
	}
}
