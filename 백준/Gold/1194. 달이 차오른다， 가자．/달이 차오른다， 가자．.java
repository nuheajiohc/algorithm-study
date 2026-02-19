import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static char[][] board;
	static int[][][] visited;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		visited = new int[N][M][64];
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				board[i][j] = line.charAt(j);
				if(board[i][j]=='0') {
					board[i][j] = '.';
					queue.offer(new int[] {i,j,0});
					visited[i][j][0] = 1;
				}
			}
		}
		
		int min = bfs(queue);
		System.out.println(min);
	}
	
	static int bfs(Queue<int[]> queue) {
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int bit = cur[2];
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx<0|| nx>=N || ny<0 || ny>=M) continue;
				if(board[nx][ny]=='#') continue;
				
				if(board[nx][ny]=='1') {
					return visited[x][y][bit];
				}
				
				int nextBit = bit;
				if(board[nx][ny]>='a' && board[nx][ny]<='z') {
					int key = 1<<(board[nx][ny]-'a');
					nextBit = bit | key;
				}else if(board[nx][ny]>='A' && board[nx][ny]<='Z') {
					int key = 1<<(board[nx][ny]-'A');
					if((nextBit & key) == 0) continue;
				}
				
				if(visited[nx][ny][nextBit]!=0)continue;
				visited[nx][ny][nextBit] = visited[x][y][bit] + 1;
				queue.offer(new int[] {nx, ny, nextBit});
			}
		}
		return -1;
	}

}
