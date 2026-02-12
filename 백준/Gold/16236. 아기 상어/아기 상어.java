import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] space;
	static int sharkSize = 2, count, time;
	static int posX, posY;
	static int[] dx = {-1, 0, 0, 1},  dy = {0, -1, 1, 0};
	static int SHARK = 9;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		space = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == SHARK) {
					posX = i;
					posY = j;
				}
			}
		}
		
		while(true) {
			int dis = moveable();
			if(dis>0) {
				move(dis);
			}else {
				break;
			}
		}
		
		System.out.println(time);
	}
	
	static int moveable() {
		int[][] dist = new int[N][N];
		dist[posX][posY] = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {posX, posY});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(isOutOfRange(nx,ny)) continue;
				if(dist[nx][ny]>0 || space[nx][ny]>sharkSize) continue;
				if(space[nx][ny]!=0 && space[nx][ny]<sharkSize) {
					return dist[x][y];
				}
				dist[nx][ny] = dist[x][y] + 1;
				queue.offer(new int[] {nx, ny});
			}
		}
		return 0;
	}
	
	static void move(int dis) {
		int[][] dist = new int[N][N];
		dist[posX][posY] = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {posX, posY});
		
		int targetX=N;
		int targetY=N;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(isOutOfRange(nx,ny)) continue;
				if(dist[nx][ny]>0 || space[nx][ny]>sharkSize) continue;
				if(space[nx][ny]!=0 && space[nx][ny]<sharkSize && dist[x][y]==dis) {
					if(targetX>nx || (targetX==nx && targetY>ny)) {
						targetX = nx;
						targetY = ny;
					}
					dist[nx][ny] = dist[x][y] + 1;
					continue;
				}
				dist[nx][ny] = dist[x][y] + 1;
				queue.offer(new int[] {nx, ny});
			}
		}
		count++;
		space[targetX][targetY] = SHARK;
		space[posX][posY] = 0;
		time+=dist[targetX][targetY]-1;
		posX=targetX;
		posY=targetY;
		if(count==sharkSize) {
			sharkSize++;
			count=0;
		}
	}
	
	static boolean isOutOfRange(int x, int y) {
		return x<0 || x>=N || y<0 || y>=N;
	}

}
