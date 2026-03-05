import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static List<int[]>[] adj;
	static int diameter;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[p].add(new int[] {c, w});
		}
		
		calMaxdiameter(1);
		System.out.println(diameter);
	}
	
	static int calMaxdiameter(int node) {	
		int maxLen = 0;
		int secondLen = 0;
		
		for(int[] next : adj[node]) {
			int nv = next[0];
			int nw = next[1];
			
			int tmp = calMaxdiameter(nv) + nw;
			
			if(tmp > maxLen) {
				secondLen = maxLen;
				maxLen = tmp;
			} else if(tmp > secondLen) {
				secondLen = tmp;
			}
		}

		diameter = Math.max(diameter, maxLen+secondLen);
		
		return maxLen;
	}
}