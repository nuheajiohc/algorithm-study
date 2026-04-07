import java.io.*;
import java.util.*;

public class Solution {

	static int D, W, K;
	static int[][] film, copied;
	static int[] status; // -1 skip, 0 A, 1 B
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			copied = new int[D][W];

			count = 14;
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			status = new int[D];
			Arrays.fill(status, -1);
			subset(0, 0);
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	static void subset(int depth, int cnt) {
		if(count<=cnt) return;
		
		if(depth==D) {
			initCopied();
			convert();
			boolean passed = pass(cnt);
			if(passed) {
				count = cnt;
			}
			return;
		}
		
		subset(depth+1, cnt);
		for(int i=0; i<2; i++) {
			status[depth] = i;
			subset(depth+1, cnt+1);
			status[depth] = -1;
		}
	}
	
	static boolean pass(int c) {
		int cnt = 0;
		for(int j=0; j<W; j++) {
			int tmp = 1;
			for(int i=1; i<D; i++) {
				if(copied[i-1][j] == copied[i][j]) {
					tmp++;
				}else {
					tmp=1;
				}
				if(tmp>=K) {
					cnt++;
					break;
				}
			}
		}
		return cnt == W;
	}
	
	static void convert() {
		for(int i=0; i<D; i++) {
			if(status[i]==-1) continue;
			for(int j=0; j<W; j++) {
				copied[i][j] = status[i];
			}
		}
	}
	
	
	static void initCopied() {
		for(int i=0; i<D; i++) {
			for(int j=0; j<W; j++) {
				copied[i][j] = film[i][j];
			}
		}
	}
}
