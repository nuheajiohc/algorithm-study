import java.io.*;
import java.util.*;

public class Solution {
	
	private static int N,M;
	private static boolean[] used;
	private static int[][] invalid;
	private static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			invalid = new int[M][2];
			used = new boolean[N];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				invalid[i] = new int[] {a, b};
			}
			
			cnt = 0;
			combination(0);
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	public static void combination(int depth) {
		if(depth==N) {
			for(int[] num : invalid) {
				if(used[num[0]] && used[num[1]]) {
					return;
				}
			}
			cnt++;
			return;
		}
		
		used[depth] = true;
		combination(depth+1);
		
		used[depth] = false;
		combination(depth+1);
	}
}
