import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[] num;
	static int min, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int plus = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			int multi = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			calculate(plus, minus, multi, div, num[0], 0);
			
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void calculate(int plus, int minus, int multi, int div, int result, int depth) {
		if(depth==N-1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		
		if(plus>0) {
			calculate(plus-1, minus, multi, div, result+num[depth+1], depth+1);
		}
		
		if(minus>0) {
			calculate(plus, minus-1, multi, div, result-num[depth+1], depth+1);
		}
		
		if(multi>0) {
			calculate(plus, minus, multi-1, div, result*num[depth+1], depth+1);
		}
		if(div>0) {
			calculate(plus, minus, multi, div-1, result/num[depth+1], depth+1);
		}
	}

}
