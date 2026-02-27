import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		pq1.offer(-10001);
		pq2.offer(10001);
		
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			int num = Integer.parseInt(br.readLine());
			
			pq1.offer(num);
			
			if(pq1.peek() > pq2.peek()) {
				pq2.offer(pq1.poll());
				pq1.offer(pq2.poll());
			}
			
			if(pq1.size()>pq2.size()+1) {
				pq2.offer(pq1.poll());
			}
			
			sb.append(pq1.peek()).append("\n");
		}
		
		System.out.println(sb);
	}

}
