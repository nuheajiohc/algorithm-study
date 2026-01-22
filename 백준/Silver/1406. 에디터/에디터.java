import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		Deque<Character> stack1 = new ArrayDeque<>();
		Deque<Character> stack2 = new ArrayDeque<>();
		
		for(int i=0; i<str.length(); i++) {
			stack1.push(str.charAt(i));
		}
		
		while(M-->0) {
			String line = br.readLine();
			
			char command = line.charAt(0);
			if(line.length()==1) {
				switch(command) {
					case 'L':
						if(!stack1.isEmpty()) {
							stack2.push(stack1.pop());
						}
						break;
					case 'D':
						if(!stack2.isEmpty()) {
							stack1.push(stack2.pop());
						}
						break;
					case 'B':
						if(!stack1.isEmpty()) {
							stack1.pop();
						}
						break;
				}
			} else {
				char target = line.charAt(2);
				stack1.push(target);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack1.isEmpty()) {
			sb.append(stack1.pollLast());
		}
		while(!stack2.isEmpty()) {
			sb.append(stack2.pollFirst());
		}
		System.out.println(sb);
	}

}
