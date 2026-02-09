import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] board;
	static int[] dx = {0,0,0,1,-1}, dy = {0,1,-1,0,0};
	static int CORE = 1, BLANK = 0;
	static int[][] cores;
	static int[] direction;
	static int size, coreNum, lineSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			cores = new int[12][2];
			direction = new int[12];
			size = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]==CORE && (i>0 && i<N-1 && j>0 && j<N-1)) 
						cores[size++] = new int[] {i, j};
				}
			}
			
			coreNum = 0;
			lineSum = 0;
			permutation(0, 0);
			
			sb.append("#").append(tc).append(" ").append(lineSum).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void permutation(int depth, int cnt) {
		if(depth == size) {
			if(coreNum < cnt) {
				coreNum = cnt;
				lineSum = calLineSum();
			}else if(coreNum == cnt) {
				lineSum = Math.min(lineSum, calLineSum());
			}
			return;
		}
		
		for(int dir=0; dir<5; dir++) {
			direction[depth] = dir;
			if(direction[depth] == 0) {
				permutation(depth+1, cnt);
			}else {
				int x = cores[depth][0];
				int y = cores[depth][1];
				
				if(!canConnect(x, y, dir)) continue;
				connect(x, y, dir, -1);
				permutation(depth+1, cnt+1);
				connect(x, y, dir, 1);	
			}
		}
	}
	
	static boolean canConnect(int x, int y, int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx<0 || nx >=N || ny<0 || ny>=N) return true;
		if(board[nx][ny]<0 || board[nx][ny]==CORE) return false;
		
		return canConnect(nx, ny, dir);
	}
	
	static void connect(int x, int y, int dir, int status) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx<0 || nx >=N || ny<0 || ny>=N) return;
		
		board[nx][ny] += status;
		connect(x+dx[dir], y+dy[dir], dir, status);
	}

	static int calLineSum() {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j]<0) cnt++;
			}
		}
		return cnt;
	}
	
}
