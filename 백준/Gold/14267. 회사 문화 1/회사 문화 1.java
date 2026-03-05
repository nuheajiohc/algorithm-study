import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] parent, good;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		good = new int[N+1];
		parent = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		for(int i=2; i<=N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			good[i] += w;
		}

		for(int i=2; i<=N; i++) {
			int p = parent[i];
			good[i] += good[p];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(good[i]).append(" ");
		}
		System.out.println(sb);
	}
}
