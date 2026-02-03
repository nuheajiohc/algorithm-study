import java.io.*;
import java.util.*;

public class Main {
	
	private static int N,M;
	private static StringBuilder sb = new StringBuilder();
	private static int[] arr;
	private static boolean[] used;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		used = new boolean[N+1];
		btk(0);
		System.out.println(sb);
	}
	
	public static void btk(int cur) {
		if(cur>=M) {
			for(int v : arr) {
				sb.append(v).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(used[i]) continue;
			arr[cur] = i;
			used[i] = true;
			btk(cur+1);
			used[i] = false;
		}
	}
}
