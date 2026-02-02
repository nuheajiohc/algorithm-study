import java.io.*;
import java.util.*;

public class Solution {
	
	private static int[] dx = {0,1,-1,0}, dy = {1,0,0,-1};
	private static int t;
	private static char[][] board = new char[16][16];
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=1; i<=10; i++) {
			t = Integer.parseInt(br.readLine());
			for(int j=0; j<16; j++) {
				board[j] = br.readLine().toCharArray();
			}
			
			sb.append("#").append(i).append(" ").append(bfs()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int bfs() {
		Deque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{1,1});
		board[1][1]='1';
		while(!queue.isEmpty()) {
			int[] cur = queue.pollFirst();
			for(int dir=0; dir<4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx<0 || nx>=16 || ny<0 || ny>=16) continue;
				if(board[nx][ny]=='3') {
					return 1;
				}
				if(board[nx][ny]=='0') {
					queue.offerLast(new int[] {nx, ny});
					board[nx][ny]='1';
				}
			}
		}
		return 0;
	}
}
