import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int tc= 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int [N][N];
			dist = new int [N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dijkstra();
			
			sb.append("Problem ").append(tc).append(": ").append(dist[N-1][N-1]).append("\n");
			tc++;
		}
		System.out.println(sb);
	}

	static void dijkstra() {
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
		dist[0][0] = map[0][0];
		pq.offer(new int[] {0, 0, dist[0][0]});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int x = now[0];
			int y = now[1];
			int w = now[2];
			
			if(dist[x][y] != w) continue;
		
			
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				
				int nw = map[nx][ny];
				
				if(dist[nx][ny] <= dist[x][y]+ nw) continue;
				dist[nx][ny] = dist[x][y] + nw;
				pq.offer(new int[] {nx, ny, dist[nx][ny]});
			}
		}
	}

}
