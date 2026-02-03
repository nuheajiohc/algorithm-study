import java.io.*;
import java.util.*;

public class Main {
	
	private static int N,K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] vis = new int[100001];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(N);
		vis[N] = 1;
		while(!queue.isEmpty()) {
			 int value = queue.poll();
			 
			 if(value+1<=100000 && vis[value+1]==0) {
				 vis[value+1] = vis[value] + 1;
				 queue.offer(value+1);
			 }
			 
			 if(value-1>=0 && vis[value-1]==0) {
				 vis[value-1] = vis[value] + 1;
				 queue.offer(value-1);
			 }
			 
			 if(value*2<=100000 && vis[value*2]==0) {
				 vis[value*2] = vis[value] + 1;
				 queue.offer(value*2);
			 }
			 
			 if(vis[K]>0) break;
		}
	
		System.out.println(vis[K]-1);
	}
}
