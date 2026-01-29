import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			StringBuilder result = new StringBuilder();
			
			int length = Math.max(a.length(), b.length());
			
			int next = 0;
			for(int i=0; i<length; i++) {
				int aa=0;
				int bb=0;
				if(a.length()>i) {
					aa = a.charAt(a.length()-1-i)-'0';
				}
				
				if(b.length()>i) {
					bb = b.charAt(b.length()-1-i)-'0';
				}
				
				int sum = aa+bb;
				result.append((sum+next)%10);
				next = (sum+next)/10;
			}
			if(next>0) {
				result.append(next);
			}
			sb.append("#").append(t).append(" ").append(result.reverse()).append("\n");
		}
		System.out.println(sb);
	}
}
