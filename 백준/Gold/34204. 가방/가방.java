import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] weight = new int[N+1];
		for(int i=1; i<=N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(weight);
		
		long[] prefixSum = new long[N+1];
		for(int i=1; i<=N; i++) {
			prefixSum[i] = prefixSum[i-1] + weight[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		int idx=1;
		for(int i=1; i<=C; i++) {
			if(N-K>=idx && i>=prefixSum[idx]) idx++;

			if(N-K<idx || i<=prefixSum[idx]) {
				sb.append(prefixSum[idx+K-1]-prefixSum[idx-1]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
