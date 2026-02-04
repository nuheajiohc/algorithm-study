import java.io.*;
import java.util.*;

public class Main {
	
	private static int[] dx = {0,0,1,-1,0,0}, dy = {1,-1,0,0,0,0}, dz = {0,0,0,0,1,-1};
	private static int M,N,H;
	private static int[][][] board;
	private static int remainder;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		board = new int[H][N][M];
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++){
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					if(board[i][j][k]==1) {
						queue.offer(new int[] {i,j,k});
					}
					if(board[i][j][k]==0) remainder++;
				}
			}
		}
		
		int day = 0;
		while(true) {
			int size = queue.size();
			
			while(size-->0) {
				int[] cur = queue.poll();
				for(int dir=0; dir<6; dir++) {
					int nz = cur[0] + dz[dir];
					int nx = cur[1] + dx[dir];
					int ny = cur[2] + dy[dir];
					if(nx<0 || nx>=N || ny<0 || ny>=M || nz<0 || nz>=H) continue;
					if(board[nz][nx][ny]!=0) continue;
					board[nz][nx][ny] = 1;
					queue.offer(new int[] {nz, nx ,ny});
					remainder--;
				}	
			}
			if(queue.isEmpty()) break;
			day++;
		}
		
		if(remainder>0) {
			System.out.println(-1);
		}else {
			System.out.println(day);
		}
	}
}
