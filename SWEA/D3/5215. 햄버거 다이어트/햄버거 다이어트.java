import java.io.*;
import java.util.*;

public class Solution {
	
	private static int N, L;
	private static int[][] arr;
	private static boolean[] used;
	private static int highScore;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			highScore = 0;
			arr = new int[N][2];
			used = new boolean[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i] = new int[] {a,b};
			}
			
			btk(0);
			
			sb.append("#").append(t).append(" ").append(highScore).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void btk(int depth) {
		if(depth==N) {
			int score = 0;
			int kcal = 0;
			for(int i=0; i<N; i++) {
				if(used[i]) {
					score += arr[i][0];
					kcal += arr[i][1];
				}
			}
			
			if(kcal<=L) {
				highScore = Math.max(highScore, score);
			}
			return;
		}
		
		used[depth] = true;
		btk(depth+1);
		used[depth] = false;
		btk(depth+1);
	}
}
