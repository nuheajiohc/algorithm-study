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
	static int[][] room, tmp;
	static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
	static List<Integer> machine = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		tmp = new int[R][C];

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
		for(int i=0; i<R; i++){
			Arrays.fill(tmp[i], 0);
		}

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(room[i][j]<5) continue;

				int amount = room[i][j]/5;
				int cnt = 0;

				for(int dir=0; dir<4; dir++) {
					int nx = i + dx[dir];
					int ny = j + dy[dir];
					if(nx<0 || nx>=R || ny<0 || ny>=C) continue;
					if(room[nx][ny]==-1) continue;
					tmp[nx][ny] += amount;
					cnt++;
				}
				room[i][j] -= amount * cnt;
			}
		}

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				if(tmp[i][j] > 0){
					room[i][j] += tmp[i][j];
				}
			}
		}
	}
	
	static void clean() {
		int top = machine.get(0);
		int bottom = machine.get(1);

    	int[] dxTop = {-1, 0, 1, 0};
    	int[] dyTop = {0, 1, 0, -1};
    	rotate(top, 0, top, dxTop, dyTop);

    	int[] dxBottom = {1, 0, -1, 0};
    	int[] dyBottom = {0, 1, 0, -1};
    	rotate(bottom, bottom, R-1, dxBottom, dyBottom);
	}

	static void rotate(int startX, int minRow, int maxRow, int[] dx, int[] dy){
		int x = startX;
		int y = 0;
		int dir = 0;

		while(dir<4){
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if(nx<minRow || nx>maxRow || ny<0 || ny>=C){
				dir++;
				continue;
			}

			if(nx==startX && ny == 0){
				room[x][y] = 0;
				break;
			}

			if(room[x][y] != -1){
				room[x][y] = room[nx][ny];
			}

			x = nx;
			y = ny;
		}
	}
}
