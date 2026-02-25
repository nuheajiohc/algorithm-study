import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] A, B;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		B = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				A[i][j] = line.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<M; j++) {
				B[i][j] = line.charAt(j)-'0';
			}
		}
		
		int cnt = simulation();
		System.out.println(cnt);
	}
	
	static int simulation() {
		int cnt = 0;
		for(int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-3; j++) {
				if(A[i][j]!=B[i][j]) {
					flip(i,j);
					cnt++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j]!=B[i][j]) return -1;
			}
		}
		
		return cnt;
	}
	
	static void flip(int x, int y) {
		for(int i=x; i<x+3; i++) {
			for(int j=y; j<y+3; j++) {
				A[i][j] = (A[i][j] + 1)%2;
			}
		}
	}

}
