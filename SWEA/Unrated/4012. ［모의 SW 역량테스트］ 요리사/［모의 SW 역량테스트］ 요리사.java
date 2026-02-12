import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] board;
	static boolean[] ingredients;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			
			ingredients = new boolean[N];
			combination(0, 0);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void combination(int depth, int k) {
		if(depth==N/2) {
			calculateDiff();
			return;
		}
		
		for(int i=k; i<N; i++) {
			if(depth==0 && i>=N/2) return;
			ingredients[i] = true;
			combination(depth+1, i+1);
			ingredients[i] = false;
		}
	}
	
	static void calculateDiff() {
		int synergy1 = 0;
		int synergy2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(ingredients[i] && ingredients[j]) synergy1+=board[i][j];
				if(!ingredients[i]&& !ingredients[j]) synergy2+=board[i][j];
			}
		}
		min = Math.min(min, Math.abs(synergy1-synergy2));
	}

}
