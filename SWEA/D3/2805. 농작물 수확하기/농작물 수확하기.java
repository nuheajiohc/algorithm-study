import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	
	static int N;
	static int[][] farm;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			farm = new int[N][N];
			for(int i=0; i<N; i++) {
				String line = br.readLine();
				for(int j=0; j<N; j++) {
					farm[i][j] = line.charAt(j)-'0';
				}
			}
			sb.append("#").append(tc).append(" ").append(bfs()).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] vis = new int[N][N];
		
		int start = N/2;
		queue.offer(new int[] {start,start});
		
		vis[start][start] = 1;
		
		int len = (N+1)/2;
		
		int sum= farm[start][start];
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(vis[nx][ny]>0) continue;
				vis[nx][ny] = vis[x][y] + 1;
				sum += farm[nx][ny];
				
				if(vis[nx][ny]==len) continue;
				queue.offer(new int[] {nx,ny});
			}
			
		}
		return sum;
	}

}
