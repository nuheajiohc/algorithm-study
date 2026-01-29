import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int test=10;
		while(test-->0) {
			 int T = Integer.parseInt(br.readLine());
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 
			 Deque<Integer> deque = new ArrayDeque<>();
			 
			 int min=Integer.MAX_VALUE;
			 while(st.hasMoreTokens()) {
				 int value = Integer.parseInt(st.nextToken());
				 deque.offerLast(value);
				 min = Math.min(min, value);
			 }
			 
		 
			 if(min>15) {
				 int a = (min/15)-1;
				 int reduceVal = a*15;
				 
				 for(int i=0; i<8; i++) {
					int value = deque.pollFirst()-reduceVal;
					deque.offerLast(value);
				 }	 
			 }
		 
			 int count=1;
			 while(deque.peekLast()!=0) {
				 
				 int cur = deque.pollFirst()-count;
				 if(cur<0) {
					 cur=0;
				 }
				 deque.offerLast(cur);
				 if(count==5) {
					 count=1;
				 }else {
					 count++;
				 }
			 }
			 sb.append("#").append(T).append(" ");
			 
			 while(!deque.isEmpty()) {
				 sb.append(deque.pollFirst()).append(" ");
			 }
			 sb.append("\n");
		}
		System.out.println(sb);
	}
}
