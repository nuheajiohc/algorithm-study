import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	
	static int H, W, N;
	static char[][] map;
	static char[] command;
	static int x=0, y=0, dir=0;
	static int[] dx = {0, -1, 0, 1}, dy = {-1, 0 ,1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			for(int i=0; i<H; i++) {
				String line = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j]=='<') {
						x=i; y=j; dir=0;
					}else if(map[i][j]=='^') {
						x=i; y=j; dir=1;
					}else if(map[i][j]=='>') {
						x=i; y=j; dir=2;
					}else if(map[i][j]=='v') {
						x=i; y=j; dir=3;
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			command = br.readLine().toCharArray();
			for(char c : command) {
				if(c=='U') {
					dir = 1;
					map[x][y] = '^';
				}else if(c=='D') {
					dir = 3;
					map[x][y] = 'v';
				}else if(c=='L') {
					dir = 0;
					map[x][y] = '<';
				}else if(c=='R') {
					dir = 2;
					map[x][y] = '>';
				}
				if(c!='S') {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					if(isOutOfRange(nx,ny)) continue;
					if(map[nx][ny]=='.') {
						map[nx][ny] = map[x][y];
						map[x][y] = '.';
						x=nx;
						y=ny;
					}
				}else {
					shoot(x+dx[dir], y+dy[dir]);	
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void shoot(int nx, int ny) {
		if(isOutOfRange(nx,ny) || map[nx][ny]=='#') {
			return;
		}
		
		if(map[nx][ny]=='*') {
			map[nx][ny]='.';
			return;
		}
		
		shoot(nx+dx[dir], ny+dy[dir]);
	}
	
	static boolean isOutOfRange(int nx, int ny) {
		return nx<0 || nx>=H || ny<0 || ny>=W;
	}
}
