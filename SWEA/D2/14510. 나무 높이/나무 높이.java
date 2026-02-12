import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N];
			int max = 0;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			
			int one = 0;
			int two = 0;
			for(int h : arr) {
				one += (max-h)%2;
				two += (max-h)/2;
			}

			int day=0;
			if(one>two) {
				day = one * 2 - 1;
			}else if(one==two) {
				day = one*2;
			}else {
				day = one*2 + (two-one+1) +  ((two-one+2)/3)-1;
			}
			
			sb.append("#").append(tc).append(" ").append(day).append("\n");
		}
		System.out.println(sb);
	}

}
