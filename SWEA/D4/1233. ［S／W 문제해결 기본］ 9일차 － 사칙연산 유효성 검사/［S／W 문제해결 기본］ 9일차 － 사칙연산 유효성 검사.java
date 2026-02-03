import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			
			int op = 0;
			int num = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				if(!isNum(st.nextToken())) {
					op++;
				}else if(op==N/2) {
					num++;
				}
			}
		
			if(op<num && op+num==N) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean isNum(String target) {
		return !(target.equals("*") || target.equals("/") || target.equals("+") || target.equals("-"));
	}
}
