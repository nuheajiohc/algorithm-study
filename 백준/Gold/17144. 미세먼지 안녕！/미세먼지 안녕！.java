import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C,T;
	static int[][] room;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	static List<Integer> machine = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==-1) {
					machine.add(i);
				}
			}
		}
		
		while(T-->0) {
			spread();
			clean();
		}
		
		
		int result = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(room[i][j]<=0) continue;
				result += room[i][j];
			}
		}
		
		System.out.println(result);
	}
	
	static void spread() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(room[i][j]>0) queue.offer(new int[] {i,j, room[i][j]});
			}
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int quantity = cur[2];
			if(room[x][y]<5) continue;
			
			int cnt = 0;
			for(int dir=0; dir<4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
				if(room[nx][ny]==-1) continue;
				room[nx][ny] += quantity/5;
				cnt++;
			}
			room[x][y] -= (quantity/5)*cnt;
		}
	}
	
	static void clean() {
		int x = machine.get(0);
		
		for(int i=x-2; i>=0; i--) {
			room[i+1][0] = room[i][0];
		}
		
		for(int j=1; j<C; j++) {
			room[0][j-1] = room[0][j];
		}
		
		for(int i=1; i<=x; i++) {
			room[i-1][C-1] = room[i][C-1];
		}
		
		for(int j=C-1; j>1; j--) {
			room[x][j] = room[x][j-1];
		}
		
		room[x][1] = 0;
		
		
		x = machine.get(1);
		
		for(int i=x+2; i<R; i++) {
			room[i-1][0] = room[i][0];
		}
		
		for(int j=1; j<C; j++) {
			room[R-1][j-1] = room[R-1][j];
		}
		
		for(int i=R-1; i>x; i--) {
			room[i][C-1] = room[i-1][C-1];
		}
		
		for(int j=C-1; j>1; j--) {
			room[x][j] = room[x][j-1];
		}
		room[x][1] = 0;
	}
}
