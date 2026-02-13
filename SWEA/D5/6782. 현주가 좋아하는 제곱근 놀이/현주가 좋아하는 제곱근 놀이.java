import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int[] dp = new int[1000001];
		for(int i=3; i<=1000000; i++) {
			int target = (int)Math.sqrt(i);
			if(target*target == i) {
				dp[i] = dp[target]+1;
			}else {
				int next = (target+1) * (target+1);
				dp[i] = dp[target+1] + next-i + 1;
			}
		}
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int tc=1; tc<=TC; tc++) {
			long N = Long.parseLong(br.readLine());
			long answer = 0;
			if(N!=2) {
				int target = (int)Math.sqrt(N);
				if((long)target*target == N) {
					answer = dp[target] + 1;
				}else {
					long next = (long)(target+1) * (target+1);
					answer = dp[target+1] + next-N + 1;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
