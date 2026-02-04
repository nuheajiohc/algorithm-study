import java.io.*;
import java.util.*;

public class Solution {
	
	private static int[] gyu, in;
	private static boolean[] used;
	private static int win, lose;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			gyu = new int[9];
			
			in = new int[9];
			used = new boolean[19];
			
			win = 0;
			lose = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				used[gyu[i]] = true;
			}
			
			comb(0);
			
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void comb(int depth) {
		if(depth==9) {
			int gyuScore = 0;
			int inScore = 0;
			for(int i=0; i<9; i++) {
				if(gyu[i] > in[i]) {
					gyuScore += gyu[i] + in[i];
				}else {
					inScore += gyu[i] + in[i];
				}
			}
			
			if(gyuScore > inScore) {
				win++;
			}else if(gyuScore < inScore) {
				lose++;
			}
			
			return;
		}
		
		for(int i=1; i<19; i++) {
			if(used[i]) continue;
			used[i] = true;
			in[depth] = i;
			comb(depth+1);
			used[i] = false;
		}
	}

}