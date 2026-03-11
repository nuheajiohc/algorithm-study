import java.io.*;
import java.util.*;

public class Main {

	static int R, C;
	static char[][] map;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int count = 0;
		for (int r = 0; r < R; r++) {
			if (canConnect(r, 0)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	static boolean canConnect(int x, int y) {
		map[x][y] = 'x';
		if(y==C-1) return true;
		
		for(int dir=0; dir<3; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx<0 || nx>=R) continue;
			if(map[nx][ny]=='x') continue;
			
			if(canConnect(nx ,ny)) return true;
		}
		
		return false;
	}
}
