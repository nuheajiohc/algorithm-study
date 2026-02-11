import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N,B;
	static int[] height;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(tc).append(" ").append(btk(0, 0)).append("\n");
		}
		System.out.println(sb);

	}

	static int btk(int depth, int sum) {
		if(depth == N) {
			return sum>=B?sum-B:Integer.MAX_VALUE;
		}
		
		int pick = btk(depth+1, sum+height[depth]);
		int skip = btk(depth+1, sum);
		
		return Math.min(pick, skip);
	}
}
