import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			String command = br.readLine();
			
			Deque<Character> deque1 = new ArrayDeque<>();
			Deque<Character> deque2 = new ArrayDeque<>();
			
			for(char c : command.toCharArray()) {
				switch(c) {
					case '<':
						if(!deque1.isEmpty()) {
							deque2.offerFirst(deque1.pollLast());
						}
						break;
					case '>':
						if(!deque2.isEmpty()) {
							deque1.offerLast(deque2.pollFirst());
						}
						break;
					case '-':
						if(!deque1.isEmpty()) {
							deque1.pollLast();
						}
						break;
					default:
						deque1.offerLast(c);
				}
			}
			for(char c : deque1) {
				sb.append(c);
			}
			
			for(char c : deque2) {
				sb.append(c);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
