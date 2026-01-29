import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Deque<String> queue1 = new ArrayDeque<>();
			Deque<String> queue2 = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int count2 = N/2;
			int count1= N-count2;
			while(count1-->0) {
				queue1.offer(st.nextToken());
			}
			while(count2-->0) {
				queue2.offer(st.nextToken());
			}
			
			sb.append("#").append(t).append(" ");
			while(!queue1.isEmpty() || !queue2.isEmpty()) {
				if(!queue1.isEmpty())
					sb.append(queue1.pollFirst()).append(" ");
				if(!queue2.isEmpty())
					sb.append(queue2.pollFirst()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
