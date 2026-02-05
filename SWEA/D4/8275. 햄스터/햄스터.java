import java.io.*;
import java.util.*;

public class Solution {
	
	private static int N, X, M;
	private static int[][] records;
	private static int[] hamsters, target;
	private static int sum;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sum = -1;
			hamsters = new int[N];
			target = new int[N];
			records = new int[M][3];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				records[i] = new int[] {l-1, r-1, s};
			}
			
			btk(0);
			
			sb.append("#").append(t).append(" ");
			
			if(sum==-1) {
				sb.append(-1).append("\n");
			}else {
				for(int i=0; i<N; i++) {
					sb.append(target[i]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void btk(int depth) {
		if(depth==N) {
			check();
			return;
		}
		
		for(int i=0; i<=X; i++) {
			hamsters[depth] = i;
			
			btk(depth+1);
		}
	}
	
	public static void check() {
		for(int i=0; i<M; i++) {
			int l = records[i][0];
			int r = records[i][1];
			int s = records[i][2];
			
			int tmp = 0;
			for(int j=l; j<=r; j++) {
				tmp += hamsters[j];
			}
			if(tmp!=s) return;
		}
		
		int tmp = 0;
		for(int i=0; i<N; i++) {
			tmp += hamsters[i];
		}
		
		if(tmp > sum) {
			for(int i=0; i<N; i++) {
				target[i] = hamsters[i];
			}
			
			sum = tmp;
		}
	}
}
