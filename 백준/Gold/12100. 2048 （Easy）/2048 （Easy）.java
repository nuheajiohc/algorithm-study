import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] board, copied;
	static int[] direction = new int[5];
	static int[] dx = { -1, 0, 1, 0 }; //상좌하우
	static int[] dy = { 0, -1, 0, 1 };
	
	static int maxBlockValue = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		copied = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(0);
		System.out.println(maxBlockValue);
	}

	static void permutation(int depth) {
		if(depth==5) {
			int blockValue = moveBlock();
			maxBlockValue = Math.max(maxBlockValue, blockValue);
			return;
		}
		
		for(int dir=0; dir<4; dir++) {
			direction[depth] = dir;
			permutation(depth+1);
		}
	}
	
	static int moveBlock() {
		for(int i=0; i<N; i++) {
			copied[i] = board[i].clone();
		}
		
		
		for(int c=0; c<5; c++) {
			int dir = direction[c];
			
			if (dir == 0) { // 상
	            for (int j = 0; j < N; j++) {
	                int[] temp = new int[N];
	                int idx = 0;
	                for (int i = 0; i < N; i++) {
	                    if (copied[i][j] == 0) continue;
	                    if (temp[idx] == 0) {
	                        temp[idx] = copied[i][j];
	                    } else if (temp[idx] == copied[i][j]) {
	                        temp[idx] *= 2;
	                        idx++;
	                    } else {
	                        idx++;
	                        temp[idx] = copied[i][j];
	                    }
	                }
	                for (int i = 0; i < N; i++) copied[i][j] = temp[i];
	            }
	        } else if (dir == 1) { // 좌
	            for (int i = 0; i < N; i++) {
	                int[] temp = new int[N];
	                int idx = 0;
	                for (int j = 0; j < N; j++) {
	                    if (copied[i][j] == 0) continue;
	                    if (temp[idx] == 0) temp[idx] = copied[i][j];
	                    else if (temp[idx] == copied[i][j]) temp[idx++] *= 2;
	                    else temp[++idx] = copied[i][j];
	                }
	                for (int j = 0; j < N; j++) copied[i][j] = temp[j];
	            }
	        } else if (dir == 2) { // 하
	            for (int j = 0; j < N; j++) {
	                int[] temp = new int[N];
	                int idx = N - 1;
	                for (int i = N - 1; i >= 0; i--) {
	                    if (copied[i][j] == 0) continue;
	                    if (temp[idx] == 0) temp[idx] = copied[i][j];
	                    else if (temp[idx] == copied[i][j]) {
	                        temp[idx] *= 2;
	                        idx--;
	                    } else {
	                        idx--;
	                        temp[idx] = copied[i][j];
	                    }
	                }
	                for (int i = 0; i < N; i++) copied[i][j] = temp[i];
	            }
	        } else if (dir == 3) { // 우
	            for (int i = 0; i < N; i++) {
	                int[] temp = new int[N];
	                int idx = N - 1;
	                for (int j = N - 1; j >= 0; j--) {
	                    if (copied[i][j] == 0) continue;
	                    if (temp[idx] == 0) temp[idx] = copied[i][j];
	                    else if (temp[idx] == copied[i][j]) {
	                        temp[idx] *= 2;
	                        idx--;
	                    } else {
	                        idx--;
	                        temp[idx] = copied[i][j];
	                    }
	                }
	                for (int j = 0; j < N; j++) copied[i][j] = temp[j];
	            }
	        }
		}
		
		int value = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				value = Math.max(value, copied[i][j]);
			}
		}
		return value;
	}
}
