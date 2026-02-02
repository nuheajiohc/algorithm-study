import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
	static char[][] board = new char[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		for(int i=0; i<101; i++) {
			Arrays.fill(board[i], '#');
		}
		
		int x = 50;
		int y = 50;
		board[x][y] = '.';
		int direction = 0;
		for(char c : arr) {
			switch(c) {
				case 'R':
					direction = (direction+3)%4;
					break;
				case 'F':
					x += dx[direction];
					y += dy[direction];
					board[x][y] = '.';
					break;
				case 'L':
					direction = (direction+1)%4;
					break;
			}
		}
		
		int top = 0;
		int left = 0;
		int right = 0;
		int bottom = 0;
		
		for(int i=0; i<=100; i++) {
			if(validX(i)) {
				top = i;
				break;
			}
		}
		
		for(int i=100; i>=0; i--) {
			if(validX(i)) {
				bottom = i;
				break;
			}
		}
		
		for(int j=0; j<=100; j++) {
			if(validY(j)) {
				left = j;
				break;
			}
		}
		
		for(int j=100; j>=0; j--) {
			if(validY(j)) {
				right = j;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=top; i<=bottom; i++) {
			for(int j=left; j<=right; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean validX(int i) {
		for(int j=0; j<=100; j++) {
			if(board[i][j]=='.') return true;
		}
		return false;
	}
	
	public static boolean validY(int j) {
		for(int i=0; i<=100; i++) {
			if(board[i][j]=='.') return true;
		}
		return false;
	}

}
