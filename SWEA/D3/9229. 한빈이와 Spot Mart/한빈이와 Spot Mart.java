import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] snacks = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(snacks);
			
			int max = -1;
			int start = 0;
			int end = N-1;
			while(start<end) {
				int sum = snacks[start] + snacks[end];
				if(sum<=M) {
					max = Math.max(sum, max);
					start++;
				}else {
					end--;
				}
			}
			
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
}
